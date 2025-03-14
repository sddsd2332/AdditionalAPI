package com.swallows.additionalapi.util.rsa;

import com.swallows.additionalapi.Tags;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

public class RSA {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);
    //加密
    public static String Encrypt(String data, PublicKey publicKey) {
        if (data == null || data.isEmpty() || publicKey == null) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedData = cipher.doFinal(data.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception e) {
            return null;
        }
    }

    //解密
    public static String Decrypt(String encryptedData, PrivateKey privateKey) {
        if (encryptedData == null || encryptedData.isEmpty() || privateKey == null) {
            return null;
        }

        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decryptedData, "UTF-8");
        } catch (Exception e) {
            return null;
        }
    }

    public static KeyPair CreativeRSAKeys(int keySize) {
        try {

            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(keySize);

            return keyPairGenerator.generateKeyPair();

        } catch (NoSuchAlgorithmException e) {
            LOGGER.info("未正确生成公私钥！");
            return null;
        }
    }
}
