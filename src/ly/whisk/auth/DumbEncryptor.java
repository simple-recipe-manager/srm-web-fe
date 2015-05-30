package ly.whisk.auth;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DumbEncryptor implements Encryptor {

	/**
	 * THIS IS NOT AN ENCRYPTOR!!!!!!!!!!!! DO NOT USE NOOOOOO
	 */
	public DumbEncryptor() {

	}

	@Override
	public String encrypt(String toEncrypt) {
		return Base64.getEncoder().encodeToString(
				toEncrypt.getBytes(StandardCharsets.UTF_8));
	}

	@Override
	public String decrypt(String toDecrypt) {
		return new String(Base64.getDecoder().decode(
				toDecrypt.getBytes(StandardCharsets.UTF_8)),
				StandardCharsets.UTF_8);
	}

}
