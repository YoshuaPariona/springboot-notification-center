package com.notification.center.domain.repository;

import com.notification.center.application.dto.ExternalRequest;
import com.notification.center.application.dto.ExternalResponse;

public interface ChurnExternalService {
    ExternalResponse predictChurn(ExternalRequest request);
}
