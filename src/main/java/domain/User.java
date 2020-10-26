package domain;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

/**
 * The purpose of User is to...
 *
 * @author kasper
 */
public class User {
    private static final int PASSWORD_ITTERATIONS = 65536;
    private static final int PASSWORD_LENGTH = 256; //32 bytes
    private static final SecretKeyFactory PASSWORD_FACTORY;

    static {
        SecretKeyFactory factory = null;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        PASSWORD_FACTORY = factory;
    }

    public User(String email, String role, byte[] salt, byte[] secret) {
        this.email = email;
        this.role = role;
        this.salt = salt;
        this.secret = secret;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String role;
    private byte[] salt;
    private byte[] secret;

    public byte[] getSalt() {
        return salt;
    }

    public byte[] getSecret() {
        return secret;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static byte[] genereateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public static byte[] calculateSecret(byte[] salt, String password) {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt,
                PASSWORD_ITTERATIONS,
                PASSWORD_LENGTH);
        try {
            return PASSWORD_FACTORY.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b : a) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    public static SecretKeyFactory getPasswordFactory() {
        return PASSWORD_FACTORY;
    }

    public  boolean isPasswordCorrect(String password) {
        return Arrays.equals(this.secret, calculateSecret(salt, password));
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", salt=" + byteArrayToHex(salt) +
                ", secret=" + byteArrayToHex(secret) +
                '}';
    }
}