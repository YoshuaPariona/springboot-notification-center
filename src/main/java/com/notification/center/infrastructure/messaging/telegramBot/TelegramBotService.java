package com.notification.center.infrastructure.messaging.telegramBot;

import com.notification.center.domain.model.Customer;
import com.notification.center.infrastructure.event.HighChurnEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Service
public class TelegramBotService {
    private final TelegramClient telegramClient;
    private final String chatId;

    public TelegramBotService(
            @Value("${telegram.bot.token}") String botToken,
            @Value("${telegram.bot.chat-id}") String chatId
    ) {
        this.chatId = chatId;
        this.telegramClient = new OkHttpTelegramClient(botToken);
    }

    public void sendAlarm(Customer customer) {
        /*
        String text = """
        El cliente %s acaba de obtener un valor de churn de %s
        """.formatted(customer.getName(), customer.getChurnValue());
        SendMessage message = SendMessage.builder()
                .chatId(chatId)
                .text(text)
                .build();
        try {
            telegramClient.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

         */
    }

    @EventListener
    public void onHighChurn(HighChurnEvent highChurnEvent) {
        sendAlarm(highChurnEvent.customer());
    }
}
