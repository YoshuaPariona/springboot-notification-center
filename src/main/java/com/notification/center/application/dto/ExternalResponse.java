package com.notification.center.application.dto;

import java.math.BigDecimal;

public record ExternalResponse(

        BigDecimal churnScore,
        String riskLevel

) {
}
