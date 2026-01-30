package com.notification.center.application.usecase;

import com.notification.center.domain.model.Customer;
import com.notification.center.domain.repository.CustomerRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(
            CustomerRepository customerRepository,
            ApplicationEventPublisher applicationEventPublisher
    ) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.getCustomerById(id);
    }
}
