/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kriptografi;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author Dell Vostro Chusna
 */
public class Crypto {

    private static Cipher cipher = null;

    public static void main(String[] args) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");

        keyGenerator.init(168);
        SecretKey secretKey = keyGenerator.generateKey();
        cipher = Cipher.getInstance("DESede");

        String plainText = "Kriptografi menggunakan Java Cryptography Extension";
        System.out.println("Plain Text Before Encryption\t : " + plainText);

        byte[] plainTextByte = plainText.getBytes("UTF8");
        byte[] encryptedBytes = encrypt(plainTextByte, secretKey);

        String encryptedText = new String(encryptedBytes, "UTF8");
        System.out.println("Encrypted Text After Encryption\t : " + encryptedText);

        byte[] decryptedBytes = decrypt(encryptedBytes, secretKey);
        String decryptedText = new String(decryptedBytes, "UTF8");
        System.out.println("Decrypted Text After Decryption\t : " + decryptedText);

    }

    static byte[] encrypt(byte[] plainTextByte, SecretKey secretKey) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainTextByte);
        return encryptedBytes;
    }

    static byte[] decrypt(byte[] encryptedBytes, SecretKey secretKey) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return decryptedBytes;
    }

}
