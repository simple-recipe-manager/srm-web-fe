package ly.whisk.configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.dropwizard.Configuration;

import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SrmWebConfiguration extends Configuration implements
		AssetsBundleConfiguration {

	@Valid
	@NotNull
	@JsonProperty
	private final AssetsConfiguration assets = new AssetsConfiguration();

	@Override
	public AssetsConfiguration getAssetsConfiguration() {
		return assets;
	}

}
