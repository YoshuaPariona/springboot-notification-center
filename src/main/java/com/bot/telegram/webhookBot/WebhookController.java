package com.bot.telegram.webhookBot;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Profile("/webhookBot")
@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private final WebhookBot bot;

    public WebhookController(WebhookBot bot) {
        this.bot = bot;
    }

    @PostMapping
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return bot.onUpdate(update);
    }

}
