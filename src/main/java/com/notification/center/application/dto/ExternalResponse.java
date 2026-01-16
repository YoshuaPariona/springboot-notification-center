package com.notification.center.application.dto;

import java.math.BigDecimal;

public record ExternalResponse(

        String requestId,
        BigDecimal churnScore,
        String riskLevel

) {
}
