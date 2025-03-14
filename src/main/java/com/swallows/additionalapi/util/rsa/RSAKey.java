package com.swallows.additionalapi.util.rsa;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAKey {

    private static final String PublicKeyStr = "";
    private static final String PrivateKeyStr = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIYMDlgk8fAeZL6DnknE4vs+fSrzG9+QeuvSkXmlwmUB0WinEq3lR8B2YdzcFNDUHW99O9KvVyqRRgPv+SV0OH5qe0ZbhBDfYVod0JbRiEA6RKDy8iRJJ3/lCaDilR4zzmVlOw2B0FXkdWcfcC5jYkiOq7mdrCUltDNPVul5lm+tAgMBAAECgYAFZB08ksnPLi2/ksQOM/asA5ydmlbr5B/pdZfHtHCvxsWxB40jBMZguXIgo5JLvsgrSHZcOBSRn/OYq3FR/g1aisskGhWUDsA7NNW2fEDVbLmvy3hNKuvSwxyely0BXfISXJU9bvSCf1HWi7TQ/TBMcbI1w4vjgeGD0qS8OIQ3SQJBAI5rW+F+BtbtkTJb3IQNmXBcOwrIP79DnW3J8Df1jKbEwuJY3A+77z76OEyjiruyOEzgt6ygCmyflMlM6muJBbUCQQDw82UypIj+TIBia0BKlTj1KqkN6XwbQ7S5yqhoCLpGmljZtFLi+E/WnmFAd9RKWJB2wqJkqTmO/57Gef7u7f0ZAkBm33+36tuv5lyKHrazoEskUUrIqAr78jBGPKbLFRBq6hfHfd4/c0YGnKGMIlm06LAoP+4MwHGnMsI7gdaWpJw9AkATd6bSe6ax3R52VTIBlKLgdAzqmdW0IjlE1ZHbrfDW6XuKQ157BhL1RSCYY9YcF6G8ZqdWOLH00sRSRuMJDONpAkEAgqmsuNmud7pUY0mrpNAZLNqmbAx2XON5i51WWLNREfwJ0ufN9Tla1RoxGp7IjxHQOJAkyVKwUjPD7gbvq2hfkg==";

    public static PublicKey getPublicKey() {
        try {
            byte[] decoded = Base64.getDecoder().decode(PublicKeyStr);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            return null;
        }
    }

    public static PrivateKey getPrivateKey() {
        try {

            byte[] decoded = Base64.getDecoder().decode(PrivateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getBase64PublicKeyByKeyPair(KeyPair keyPair) {
        return Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
    }

    public static String getBase64PrivateKeyByKeyPair(KeyPair keyPair) {
        return Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
    }

}
