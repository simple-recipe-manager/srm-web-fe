package ly.whisk.auth;

import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.DefaultUnauthorizedHandler;
import io.dropwizard.auth.UnauthorizedHandler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.NewCookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class WhisklyCookieAuthFactory<P> extends
		AuthFactory<NewCookie, P> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(WhisklyCookieAuthFactory.class);

	@Context
	private HttpServletRequest request;
	private final boolean required;
	private final Class<P> generatedClass;
	private UnauthorizedHandler unauthorizedHandler = new DefaultUnauthorizedHandler();

	public WhisklyCookieAuthFactory(Authenticator<NewCookie, P> authenticator,
			final Class<P> generatedClass, boolean required) {
		super(authenticator);
		this.required = required;
		this.generatedClass = generatedClass;
	}

	@Override
	public P provide() {

		if (request != null) {
			final Cookie[] cookies = request.getCookies();

			try {
				if (cookies != null) {
					for (Cookie c : cookies) {
						if (c.getName().equals(CookieHelper.COOKIE_NAME)) {
							authenticator().authenticate(
									new NewCookie(new javax.ws.rs.core.Cookie(c
											.getName(), c.getValue(), c
											.getPath(), c.getDomain(), c
											.getVersion())));
						}
					}
				}
			} catch (IllegalArgumentException e) {
				LOGGER.warn("Error decoding credentials", e);
			} catch (AuthenticationException e) {
				LOGGER.warn("Error authenticating credentials", e);
				throw new InternalServerErrorException();
			}
		}

		if (required) {
			throw new WebApplicationException();
		}

		return null;

	}

	@Override
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public AuthFactory<NewCookie, P> clone(boolean required) {
		return new WhisklyCookieAuthFactory<>(authenticator(),
				this.generatedClass, required);
	}

	@Override
	public Class<P> getGeneratedClass() {
		return generatedClass;
	}

}
