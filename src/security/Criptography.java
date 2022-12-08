package security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author SrBlackDEVs in Github
 */
public class Criptography {

    /**
     * Make the secret key to use
     * 
     * @param Key to use to encrypt
     * @return The key
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    private static String globalKey = "I am a secret key, lol!";

    private static SecretKeySpec generateKey(String key) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] Ekey = key.getBytes("UTF-8");

        MessageDigest sha = MessageDigest.getInstance("SHA-1");

        Ekey = sha.digest(Ekey);
        Ekey = Arrays.copyOf(Ekey, 16);

        SecretKeySpec secretKey = new SecretKeySpec(Ekey, "AES");

        return secretKey;
    }
    public static String getGlobalKey() {
        return globalKey;
    }

    /**
     * Encrypt with AES using the generated key
     * 
     * @param dString The string to encrypt
     * @param SecretKey The key to use
     * @return String encrypted
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static String getEncryptedString(String dString, String SecreyKey)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = generateKey(SecreyKey);

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] BytestoEncrypt = dString.getBytes("UTF-8");
        byte[] EncryptedBytes = cipher.doFinal(BytestoEncrypt);
        String encrypted = Base64.getEncoder().encodeToString(EncryptedBytes);

        return encrypted;
    }
    public static String decrypt(String EncryptedBytes, String KeySecret) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = generateKey(KeySecret);

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] BytestoDecrypt = Base64.getDecoder().decode(EncryptedBytes);
        byte[] decryptedBytes = cipher.doFinal(BytestoDecrypt);
        String decrypted = new String(decryptedBytes);

        return decrypted;
    }
}