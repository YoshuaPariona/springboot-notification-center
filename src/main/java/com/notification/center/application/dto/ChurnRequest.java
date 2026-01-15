package com.notification.center.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ChurnRequest(

        @NotBlank
        @Size(max = 50)
        String externalId,
        @NotBlank
        @Size(max = 150)
        String fullName,

        @NotBlank
        @Size(max = 150)
        @Email
        String email,

        @NotNull
        @Valid
        ExternalRequest externalRequest
) {

}
