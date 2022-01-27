package marvelapi.web;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

public class MD5Hash {
	public static Instant instant = Instant.now();
    public static long timeStamp = instant.getEpochSecond();
    public static String MD5Hashing(Long timeStamp, String marvelApiPublicKey,
                                    String marvelApiPrivateKey){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String hash = timeStamp + marvelApiPublicKey + marvelApiPrivateKey;
            return new BigInteger(1, md.digest(hash.getBytes())).toString();
        } catch (NoSuchAlgorithmException e) {
            e.getMessage();
        }
        return null;
    }
}
