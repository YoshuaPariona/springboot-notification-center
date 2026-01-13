package com.notification.center.event;

import com.notification.center.customer.Customer;

public record HighChurnEvent(Customer customer) {
}
