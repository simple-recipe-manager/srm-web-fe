package ly.whisk.resources;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import ly.whisk.auth.CookieHelper;
import ly.whisk.auth.Encryptor;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.GetIdRequest;
import com.amazonaws.services.cognitoidentity.model.GetIdResult;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenRequest;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenResult;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/authorize")
public class AuthorizeResource {

	private Encryptor encryptor;

	public AuthorizeResource(Encryptor encryptor) {
		this.encryptor = encryptor;
	}

	@GET
	@Timed
	public Response userAuthorized(@Context HttpServletRequest request,
			@QueryParam(value = "access_token") String access_token)
			throws ClientProtocolException, UnsupportedEncodingException,
			IOException {
		Content c = Request
				.Get("https://api.amazon.com/auth/o2/tokeninfo?access_token="
						+ URLEncoder.encode(access_token, "UTF-8")).execute()
				.returnContent();

		Map m = new ObjectMapper().readValue(c.toString(),
				new TypeReference<Map>() {
				});

		if (!"amzn1.application-oa2-client.4aa9777d9d07427aa4509cd182b30c76"
				.equals(m.get("aud"))) {
			// the access token does not belong to us
			throw new RuntimeException("Invalid token");
		}

		// exchange the access token for user profile
		c = Request.Get("https://api.amazon.com/user/profile")
				.addHeader("Authorization", "bearer " + access_token).execute()
				.returnContent();

		m = new ObjectMapper().readValue(c.toString(),
				new TypeReference<Map>() {
				});

		// initialize the Cognito identity client with a set
		// of anonymous AWS credentials
		AmazonCognitoIdentity identityClient = new AmazonCognitoIdentityClient(
				new AnonymousAWSCredentials());

		// send a get id request. This only needs to be executed the first time
		// and the result should be cached.
		GetIdRequest idRequest = new GetIdRequest();
		idRequest.setAccountId("224842466274");
		idRequest
				.setIdentityPoolId("us-east-1:866d80cc-24e2-4c83-b6b4-f1c722310e23");
		// If you are authenticating your users through an identity provider
		// then you can set the Map of tokens in the request
		Map<String, String> providerTokens = new HashMap<String, String>();
		providerTokens.put("www.amazon.com", access_token);
		idRequest.setLogins(providerTokens);

		GetIdResult idResp = identityClient.getId(idRequest);

		String identityId = idResp.getIdentityId();

		GetOpenIdTokenRequest getToken = new GetOpenIdTokenRequest();
		getToken.setIdentityId(identityId);

		getToken.setLogins(providerTokens);

		GetOpenIdTokenResult tokenResult = identityClient
				.getOpenIdToken(getToken);
		String token = tokenResult.getToken();

		NewCookie nc = CookieHelper.toNewCookie(identityId, token, encryptor);

		return Response
				.seeOther(UriBuilder.fromResource(IndexResource.class).build())
				.cookie(nc).build();
	}
}
