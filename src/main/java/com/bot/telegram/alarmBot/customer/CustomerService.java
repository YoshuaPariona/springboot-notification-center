package com.bot.telegram.alarmBot.customer;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomerList() {

        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        Customer customer = customerRepository.getCustomerById(id);

        if(customer.getChurnValue().compareTo(BigDecimal.valueOf(0.75))> 0) {
            System.out.println("trigger!!!!!!!!!!!!!");
        }

        return customerRepository.getCustomerById(id);
    }
}
