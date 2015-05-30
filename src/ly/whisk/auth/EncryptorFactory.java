package ly.whisk.auth;

import ly.whisk.configuration.SrmWebConfiguration;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.kms.AWSKMSClient;

public class EncryptorFactory {

	public Encryptor build(SrmWebConfiguration config) {
		AWSCredentialsProvider provider = new InstanceProfileCredentialsProvider();
		try {
			AWSCredentials creds = provider.getCredentials();
			if (creds != null) {
				AWSKMSClient client = new AWSKMSClient(provider);
				client.setRegion(config.getRegion());
				return new KMSEncryptor(client, config.getKMSKeyARN());
			}
		} catch (AmazonClientException ex) {
		}
		return new DumbEncryptor();
	}
}
