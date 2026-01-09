package com.bot.telegram.alarmBot.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public List<Customer> customerList() {

        return customerRepository.findAll();
    }
}
