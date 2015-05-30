package ly.whisk.auth;

public interface Encryptor {

	public String encrypt(String toEncrypt);

	public String decrypt(String toDecrypt);
}
