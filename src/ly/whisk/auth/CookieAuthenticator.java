package ly.whisk.auth;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;

import javax.ws.rs.core.NewCookie;

import com.google.common.base.Optional;

public class CookieAuthenticator implements Authenticator<NewCookie, SRMUser> {

	private Encryptor encryptor;

	public CookieAuthenticator(Encryptor encryptor) {
		this.encryptor = encryptor;
	}

	@Override
	public Optional<SRMUser> authenticate(NewCookie credentials)
			throws AuthenticationException {
		Optional<AuthHolder> holder = CookieHelper.fromNewCookie(credentials,
				this.encryptor);

		if (!holder.isPresent()) {
			return Optional.absent();
		} else {
			return Optional.of(new SRMUser(holder.get()));
		}
	}
}
