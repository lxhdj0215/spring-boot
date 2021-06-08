package com.lxhdj;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-03-24 14:19
 **/

public class RSAEncrypt {
    private static Map<Integer, String> keyMap = new HashMap<Integer, String>();  //用于封装随机产生的公钥与私钥

    public static void main(String[] args) throws Exception {
        //生成公钥和私钥
        genKeyPair();
        //加密字符串
        String message = "df723820";
        keyMap.put(0, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKqBQY4Gx49BP3rrjqGiETpp91CMri0TYfFGzi2YypRwuqemCBPBky+0+uKDID2+Pm3J7TEjZAPzH+VJsidn2CYe1kUIesiD4x3oB9S0dVjeGssxYYAclIXGBQbPc3FxkxaGsmMzsXYcx8KcfRuR/z8a80eCDB9YTExKxL9j09gwIDAQAB");
        keyMap.put(1, "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIqoFBjgbHj0E/euuOoaIROmn3UIyuLRNh8UbOLZjKlHC6p6YIE8GTL7T64oMgPb4+bcntMSNkA/Mf5UmyJ2fYJh7WRQh6yIPjHegH1LR1WN4ayzFhgByUhcYFBs9zcXGTFoayYzOxdhzHwpx9G5H/PxrzR4IMH1hMTErEv2PT2DAgMBAAECgYBxlm+gUXmLPKh+5yuk2/Ls3jsS7TkHxsvHejwZOo74vbLY3ZfhRxJ9qVMFIPiYILL6lRGnZ+v5hcu2xiiwetElnk4wKhQb7UFnRcm1bixKQou64LhqufkhEH5nYj1afjSQh7/S2n4BDUOWvbQTN0FjTm9TDK4XDyI4jmwOme2tgQJBANsYiaCKmHikFWJNFI0idxc0rJNDbXnVEktpVT0Ebuq4KmHi9ZorpwDyg71FKzCodgiOuD/m3s1HmOcu9Oa/LUkCQQCiAvr/AeTxl/QXkO24rk7i6BAzahcy1MOemsg4gjpKSkxa3zBvK+rZwNAY149TAHaMnAi7Sp2hMeGq4rWFOtBrAkAPA4hy2uyF3+CjQtr0rPbyPSbSVJ2M6r/9MPOpYcNkDEjDOnVQIkuocfX7I2FJTVIBVh5kKqL7+DsPJJWdtl4ZAkAGWw2TsXRU0fw+bG4W/6eSmT4BdlkAon4mG7ZdGSbGQVHrgrP4uIVXE4xWXSZ/QBZmf7yL9Gpop3dN5+TtHBiPAkApUPOU2vwmFHq9EorvG3LIYwP9KyRqJ5crPqiDw7ClkMe7hsAAbQEtg6DOYxTwrJKyoad9dZ2+0aDX7AYdv/s6");
        System.out.println("随机生成的公钥为:" + keyMap.get(0));
        System.out.println("随机生成的私钥为:" + keyMap.get(1));
        String messageEn = encrypt(message, keyMap.get(0));
        System.out.println(message + "\t加密后的字符串为:" + messageEn);
        messageEn = "DNkFd0gmpahJeCQ0W5alWMqbwzDAxPgDm6q6wrWx3EOMqw2CsD3yDyf3ZwSZSY4WzxsoDCNoeywS41KuNh+RUAOvnLCcfihIboaxYa2YlKobt1BdARU7ykmOmb4n5zCq2za72EZY8RYVs0BKI+MbIHNcfUgixxLPxJUTqtwm/Fk=";
        String messageDe = decrypt(messageEn, keyMap.get(1));
        System.out.println("还原后的字符串为:" + messageDe);
    }

    /**
     * 随机生成密钥对
     *
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        keyMap.put(0, publicKeyString);  //0表示公钥
        keyMap.put(1, privateKeyString);  //1表示私钥
    }

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

}
