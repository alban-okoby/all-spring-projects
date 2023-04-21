package com.digitalsouag.redditapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@AllArgsConstructor
public class MailContentBuilder {

    private final TemplateEngine templateEngine;

    public String build(String msg) {
        Context context = new Context();
                context.setVariable("msg", msg);
        return templateEngine.process("sendMailTemplate", context);
    }

}
