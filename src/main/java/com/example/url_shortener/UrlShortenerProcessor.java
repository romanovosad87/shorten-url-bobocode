package com.example.url_shortener;

import freemarker.template.Template;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

@Service
public class UrlShortenerProcessor {

    @SneakyThrows
    public String processTemplate(Map<String, Object> data, Template template) {
        Writer templateWriter = new StringWriter();
        template.process(data, templateWriter);
        return templateWriter.toString();
    }

    @SneakyThrows
    public Template getTemplate(FreeMarkerConfig templateConfig, String name) {
        return templateConfig.getConfiguration().getTemplate(name);
    }
}
