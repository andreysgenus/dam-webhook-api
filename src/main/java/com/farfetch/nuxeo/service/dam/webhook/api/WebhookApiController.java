package com.farfetch.nuxeo.service.dam.webhook.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
@Controller
@RequestMapping("${openapi.dAMWebhook.base-path:/jmtvms/DAMWebhookAPI/1.0}")
public class WebhookApiController implements WebhookApi {

    private final WebhookApiDelegate delegate;

    public WebhookApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) WebhookApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new WebhookApiDelegate() {});
    }

    @Override
    public WebhookApiDelegate getDelegate() {
        return delegate;
    }

}
