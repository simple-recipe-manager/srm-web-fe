package ly.whisk.auth;

public class AuthHolder {

	private String cognitoId;
	private String authToken;

	public AuthHolder() {

	}

	public String getCognitoId() {
		return cognitoId;
	}

	public void setCognitoId(String cognitoId) {
		this.cognitoId = cognitoId;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

}
