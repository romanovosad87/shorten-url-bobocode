package com.example.url_shortener;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.net.URI;

@Controller
@RequiredArgsConstructor
public class ShortenerController {
    private final ShortenerService shortenerService;

    @GetMapping
    @ResponseBody
    public String index() {
        return "Hello!";
    }


    @GetMapping("/short")
    public String shortenUrl(Model model) {
        model.addAttribute("shortenUrl", "_____________________");
        return "shortener";
    }

    @PostMapping("/short")
    public String shortenUrlPost(@RequestParam("inputUrl") String inputUrl, Model model) {
        String shortenUrl = shortenerService.shortenUrl(inputUrl);
        model.addAttribute("shortenUrl", shortenUrl);
        return "shortener";
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
