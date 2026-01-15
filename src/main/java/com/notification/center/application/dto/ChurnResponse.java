package com.notification.center.application.dto;

import java.time.LocalDateTime;

public record ChurnResponse(
        String externalId,
        LocalDateTime requestedAt,
        ExternalResponse externalResponse
) {
}
