package ly.whisk.auth;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.EncryptRequest;

public class KMSEncryptor implements Encryptor {

	private AWSKMS kmsClient;
	private String keyArn;
	private final Charset UTF_8 = StandardCharsets.UTF_8;

	public KMSEncryptor(AWSKMS kmsClient, String keyArn) {
		this.kmsClient = kmsClient;
		this.keyArn = keyArn;
	}

	/**
	 * Encrypt the string
	 * 
	 * @param toEncrypt
	 * @return the base64'd ciphertext
	 */
	public String encrypt(String toEncrypt) {

		ByteBuffer plaintext = ByteBuffer.wrap(toEncrypt.getBytes(UTF_8));

		EncryptRequest req = new EncryptRequest().withKeyId(keyArn)
				.withPlaintext(plaintext);
		ByteBuffer ciphertext = this.kmsClient.encrypt(req).getCiphertextBlob();
		return Base64.getEncoder().encodeToString(ciphertext.array());
	}

	/**
	 * Decrypts a blob, input should be the base64'd string of the ciphertext
	 * 
	 * @param toDecrypt
	 * @return the decrypted string
	 */
	public String decrypt(String toDecrypt) {

		ByteBuffer ciphertextBlob = ByteBuffer.wrap(Base64.getDecoder().decode(
				toDecrypt));

		DecryptRequest req = new DecryptRequest()
				.withCiphertextBlob(ciphertextBlob);
		ByteBuffer plainText = this.kmsClient.decrypt(req).getPlaintext();
		return new String(plainText.array(), UTF_8);
	}
}
