package com.foureyeslabs.controller;

import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.ClasspathTemplateLoader;
import de.neuland.jade4j.template.JadeTemplate;
import de.neuland.jade4j.template.TemplateLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private JadeConfiguration config;

    public HelloController() {
        this.config = new JadeConfiguration();
        TemplateLoader loader = new ClasspathTemplateLoader();
        this.config.setTemplateLoader(loader);
    }

    @RequestMapping("/greeting")
    public String greeting() {
        Map<String, Object> model = new HashMap<String, Object>();
        try {
            JadeTemplate template = config.getTemplate("classpath:view/index.jade");
            return Jade4J.render(template, model);
        } catch (final Exception ioe) {
          ioe.printStackTrace();
            return ioe.toString();
        }
    }
}
