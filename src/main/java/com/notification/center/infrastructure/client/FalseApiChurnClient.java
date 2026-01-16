package com.notification.center.infrastructure.client;

import com.notification.center.application.dto.ExternalRequest;
import com.notification.center.application.dto.ExternalResponse;
import com.notification.center.domain.repository.ChurnExternalService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class FalseApiChurnClient implements ChurnExternalService {

    @Override
    public ExternalResponse predictChurn(ExternalRequest request) {

        return new ExternalResponse(
                UUID.randomUUID().toString(),
                BigDecimal.valueOf(56),
                "LOW"
        );
    }
}
