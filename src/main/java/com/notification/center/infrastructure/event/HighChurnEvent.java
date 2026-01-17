package com.notification.center.infrastructure.event;

import com.notification.center.application.dto.ExternalResponse;
import com.notification.center.domain.model.Customer;

public record HighChurnEvent(Customer customer, ExternalResponse exResponse) {
}
