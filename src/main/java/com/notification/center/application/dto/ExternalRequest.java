package com.notification.center.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ExternalRequest(
        @Size(max = 30)
        String marketSegment,

        @NotBlank
        @Size(max = 20)
        String status,

        @Positive
        Integer totalPurchases,

        Boolean exposedToMarketing
) {
}
