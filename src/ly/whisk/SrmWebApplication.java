package ly.whisk;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
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

	@Override
	public void run(SrmWebConfiguration configuration, Environment environment)
			throws Exception {

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
