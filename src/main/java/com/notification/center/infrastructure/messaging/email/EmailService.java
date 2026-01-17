package com.notification.center.infrastructure.messaging.email;

import com.notification.center.application.dto.ExternalResponse;
import com.notification.center.domain.model.Customer;
import com.notification.center.infrastructure.event.HighChurnEvent;
import com.notification.center.infrastructure.event.MediumChurnEvent;
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

    public void sendTextEmail(Customer customer, ExternalResponse exResponse) {

        SimpleMailMessage message = new SimpleMailMessage();
        String subject = "Churn Medio en cliente %d".formatted(customer.getId());
        String body = "Le informamos que el usuario %s ha obtenido un resultado de churn de %.2f"
                .formatted(customer.getFullName(), exResponse.churnScore());
        message.setFrom(backEmail);
        message.setTo(customer.getEmail());
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);

    }

    @EventListener
    public void onMediumChurn(MediumChurnEvent mediumChurnEvent) {
        sendTextEmail(mediumChurnEvent.customer(), mediumChurnEvent.exResponse());
    }

    @EventListener
    public void onHighChurn(HighChurnEvent highChurnEvent) {
        sendTextEmail(highChurnEvent.customer(), highChurnEvent.exResponse());
    }
}
