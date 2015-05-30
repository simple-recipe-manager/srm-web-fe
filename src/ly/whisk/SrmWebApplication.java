package ly.whisk;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import java.io.IOException;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import liquibase.diff.output.StandardObjectChangeFilter.FilterType;
import ly.whisk.auth.CookieAuthenticator;
import ly.whisk.auth.SRMUser;
import ly.whisk.auth.WhisklyCookieAuthFactory;
import ly.whisk.configuration.SrmWebConfiguration;
import ly.whisk.health.ConnectionHealthCheck;
import ly.whisk.resources.AuthorizeResource;
import ly.whisk.resources.HealthCheckResource;
import ly.whisk.resources.IndexResource;
import ly.whisk.resources.RecipeResource;
import ly.whisk.storage.APIStorage;

import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;

public class SrmWebApplication extends Application<SrmWebConfiguration> {
	public static void main(String[] args) throws Exception {
		new SrmWebApplication().run(args);
	}

	@Override
	public void initialize(Bootstrap<SrmWebConfiguration> arg0) {
		arg0.addBundle(new ConfiguredAssetsBundle("/assets/", "/assets"));
		arg0.addBundle(new ViewBundle<SrmWebConfiguration>());

	}

	void addHttpsForward(ServletContextHandler handler) {
		handler.addFilter(new FilterHolder(new Filter() {

			public void init(FilterConfig filterConfig) throws ServletException {
			}

			public void doFilter(ServletRequest request,
					ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
				StringBuffer uri = ((HttpServletRequest) request)
						.getRequestURL();
				if (uri.toString().startsWith("http://")) {
					String location = "https://"
							+ uri.substring("http://".length());
					((HttpServletResponse) response).sendRedirect(location);
				} else {
					chain.doFilter(request, response);
				}
			}

			public void destroy() {
			}
		}), "*/*", EnumSet.of(DispatcherType.REQUEST));
	}

	@Override
	public void run(SrmWebConfiguration configuration, Environment environment)
			throws Exception {

		if (configuration.forwardHttps()) {
			addHttpsForward(environment.getApplicationContext());
		}

		environment.jersey().register(
				AuthFactory.binder(new WhisklyCookieAuthFactory<SRMUser>(
						new CookieAuthenticator(configuration
								.getEncryptorFactory().build(configuration)),
						SRMUser.class, true)));

		final ConnectionHealthCheck connHC = new ConnectionHealthCheck();
		environment.healthChecks().register("Connection", connHC);

		final HealthCheckResource hcR = new HealthCheckResource(
				environment.healthChecks());
		environment.jersey().register(hcR);

		final IndexResource index = new IndexResource();
		environment.jersey().register(index);

		final AuthorizeResource auth = new AuthorizeResource(configuration
				.getEncryptorFactory().build(configuration));
		environment.jersey().register(auth);

		final RecipeResource recipe = new RecipeResource(new APIStorage());
		environment.jersey().register(recipe);

	}
}
