package ly.whisk.configuration;

import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import ly.whisk.auth.EncryptorFactory;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SrmWebConfiguration extends Configuration implements
		AssetsBundleConfiguration {

	@Valid
	@NotNull
	@JsonProperty
	private final AssetsConfiguration assets = new AssetsConfiguration();

	@Valid
	@NotNull
	@JsonProperty
	private String region;

	@Valid
	@NotNull
	@JsonProperty
	private String kmsKeyArn;

	@Valid
	@NotNull
	private final EncryptorFactory encryptorFactory = new EncryptorFactory();

	@Override
	public AssetsConfiguration getAssetsConfiguration() {
		return assets;
	}

	public EncryptorFactory getEncryptorFactory() {
		return encryptorFactory;
	}

	public Region getRegion() {
		return Region.getRegion(Regions.fromName(region));
	}

	public String getKMSKeyARN() {
		return kmsKeyArn;
	}
}
