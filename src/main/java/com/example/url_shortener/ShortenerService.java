package com.example.url_shortener;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ShortenerService {

    Map<String, String> shortenerMap = new ConcurrentHashMap<>();

    public String shortenUrl(String url) {
        String key = RandomStringUtils.randomAlphabetic(6);
        shortenerMap.put(key, url);
        return buildShortUrl(key);
    }

    private String buildShortUrl(String key) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{key}")
                .buildAndExpand(key)
                .toString();
    }

    public String getUrl(String key) {
        return shortenerMap.get(key);
    }
}
