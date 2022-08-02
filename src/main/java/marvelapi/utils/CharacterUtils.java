package marvelapi.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.time.ZonedDateTime;

public class CharacterUtils {
    public static long timeStamp = ZonedDateTime.now().toInstant().toEpochMilli();
    public static String md5Apache(String publicApiKey, String privateApiKey, Long timeStamp) {

        return DigestUtils.md5Hex(timeStamp + privateApiKey + publicApiKey);
    }
}
