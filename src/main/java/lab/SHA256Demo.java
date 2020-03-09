package lab;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Demo {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        String s = "你好";
        byte[] bytes = s.getBytes();
        messageDigest.update(bytes);
        byte[] result = messageDigest.digest();
        for(byte b:result){
            System.out.printf("%02x",b);
        }
    }
}
