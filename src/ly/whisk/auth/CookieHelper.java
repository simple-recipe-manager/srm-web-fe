package ly.whisk.auth;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;

public class CookieHelper {

	public static final String COOKIE_NAME = "whisklyAuth";

	public static NewCookie toNewCookie(String id, String token,
			Encryptor encryptor) throws IllegalArgumentException,
			JsonProcessingException {

		AuthHolder holder = new AuthHolder();
		holder.setAuthToken(token);
		holder.setCognitoId(id);

		return toNewCookie(holder, encryptor);

	}

	public static NewCookie toNewCookie(AuthHolder holder, Encryptor encryptor)
			throws IllegalArgumentException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Cookie cookie = new Cookie(COOKIE_NAME, encryptor.encrypt(mapper
				.writeValueAsString(holder)));
		NewCookie nc = new NewCookie(cookie, "for whiskly auth",
				NewCookie.DEFAULT_MAX_AGE, false);

		return nc;

	}

	public static Optional<AuthHolder> fromNewCookie(NewCookie cookie,
			Encryptor encryptor) {
		if (cookie == null) {
			return Optional.absent();
		}
		if (StringUtils.isBlank(cookie.getValue())) {
			return Optional.absent();
		}

		ObjectMapper mapper = new ObjectMapper();
		try {

			String decryptedValue = encryptor.decrypt(cookie.getValue());
			AuthHolder holder = mapper.readValue(decryptedValue,
					AuthHolder.class);
			return Optional.of(holder);
		} catch (Exception ex) {
			return Optional.absent();
		}
	}
}
