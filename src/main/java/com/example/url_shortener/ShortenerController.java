package com.example.url_shortener;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ShortenerController {
    private final UrlShortenerProcessor processor;
    private final FreeMarkerConfig templateConfig;
    private final ShortenerService shortenerService;


    @GetMapping("/short")
    public String shortenUrl() {
        var template = processor.getTemplate(templateConfig, "shortener.ftl");
        Map<String, Object> model = new HashMap<>();
        model.put("shortenUrl", "___________________________");
        return processor.processTemplate(model, template);
    }

    @PostMapping("/short")
    public String shortenUrlPost(@RequestParam("inputUrl") String inputUrl) {
        String shortenUrl = shortenerService.shortenUrl(inputUrl);
        var template = processor.getTemplate(templateConfig, "shortener.ftl");
        return processor.processTemplate(Map.of("shortenUrl", shortenUrl), template);
    }

    @GetMapping("short/{key}")
    public ResponseEntity<?> getOriginalUrl(@PathVariable String key) {
        String originalUrl = shortenerService.getUrl(key);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(originalUrl));
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .headers(headers)
                .build();
    }
}
