package com.notification.center.event;

import com.notification.center.customer.Customer;

public record MediumChurnEvent(Customer customer) {
}
