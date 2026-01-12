package com.bot.telegram.event;

import com.bot.telegram.customer.Customer;

public record HighChurnEvent(Customer customer) {
}
