package com.notification.center.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ChurnResponse(
        String externalId,
        LocalDateTime requestedAt,
        BigDecimal churnScore,
        String riskLevel
) {
}
