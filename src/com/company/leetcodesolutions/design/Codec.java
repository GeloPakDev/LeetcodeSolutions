package com.company.leetcodesolutions.design;

import java.util.HashMap;
import java.util.Map;

/**
 * using hashcode for longUrl stored in a Map to encode and decode from longUrl to shortUrl and vice-versa
 */
public class Codec {
    Map<String, String> longToShort = new HashMap<>();
    Map<String, String> shortToLong = new HashMap<>();

    String tinyUrlBase = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl))
            return longToShort.get(longUrl);

        String index = String.valueOf(longUrl.hashCode());
        String shortUrl = tinyUrlBase + index;
        longToShort.put(longUrl, shortUrl);
        shortToLong.put(shortUrl, longUrl);

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl);
    }
}