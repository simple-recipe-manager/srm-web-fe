package ly.whisk;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import ly.whisk.configuration.SrmWebConfiguration;
import ly.whisk.health.ConnectionHealthCheck;
import ly.whisk.resources.AuthorizeResource;
import ly.whisk.resources.HealthCheckResource;
import ly.whisk.resources.IndexResource;

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

		final ConnectionHealthCheck connHC = new ConnectionHealthCheck();
		environment.healthChecks().register("Connection", connHC);

		final HealthCheckResource hcR = new HealthCheckResource(
				environment.healthChecks());
		environment.jersey().register(hcR);

		final IndexResource index = new IndexResource();
		environment.jersey().register(index);
		
		final AuthorizeResource auth = new AuthorizeResource();
		environment.jersey().register(auth);

	}

}
