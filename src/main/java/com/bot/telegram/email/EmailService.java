package com.bot.telegram.email;

import com.bot.telegram.customer.Customer;
import com.bot.telegram.event.MediumChurnEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String backEmail;


    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendTextEmail(Customer customer) {
        SimpleMailMessage message = new SimpleMailMessage();
        String subject = "Churn Medio en cliente %d".formatted(customer.getId());
        String body = "Le informamos que el usuario %s ha obtenido un resultado de churn de %.2f".formatted(customer.getName(), customer.getChurnValue());
        message.setFrom(backEmail);
        //A sí mismo por mientras
        message.setTo(backEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);

    }

    @EventListener
    public void onMediumChurn(MediumChurnEvent mediumChurnEvent) {
        sendTextEmail(mediumChurnEvent.customer());
    }
}
