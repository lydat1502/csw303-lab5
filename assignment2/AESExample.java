package assignment2;

import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class AESExample {
    private static SecretKey secretKey;
    private static byte[] iv;

    public static String encrypt(String plainText) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        secretKey = keyGen.generateKey();

        iv = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        Cipher encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] cipherTextBytes = encryptCipher.doFinal(plainText.getBytes("UTF-8"));
        byte[] combined = new byte[iv.length + cipherTextBytes.length];
        System.arraycopy(iv, 0, combined, 0, iv.length);
        System.arraycopy(cipherTextBytes, 0, combined, iv.length, cipherTextBytes.length);
        return Base64.getEncoder().encodeToString(combined);
    }

    public static String decrypt(String encryptedText) throws Exception {
        byte[] combined = Base64.getDecoder().decode(encryptedText);
        byte[] iv = new byte[16];
        byte[] cipherTextBytes = new byte[combined.length - iv.length];
        System.arraycopy(combined, 0, iv, 0, iv.length);
        System.arraycopy(combined, iv.length, cipherTextBytes, 0, cipherTextBytes.length);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        Cipher decryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] decryptedTextBytes = decryptCipher.doFinal(cipherTextBytes);
        return new String(decryptedTextBytes, "UTF-8");
    }

    public static void main(String[] args) throws Exception {
        String plainText = "This is a secret message.";
        String cipherText = encrypt(plainText);
        System.out.println("Encrypted Text: " + cipherText);
        String decryptedText = decrypt(cipherText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}