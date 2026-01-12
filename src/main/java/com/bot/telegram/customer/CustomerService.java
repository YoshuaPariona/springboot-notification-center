package com.bot.telegram.customer;

import com.bot.telegram.event.HighChurnEvent;
import com.bot.telegram.event.MediumChurnEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public CustomerService(
            CustomerRepository customerRepository,
            ApplicationEventPublisher applicationEventPublisher
    ) {
        this.customerRepository = customerRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        Customer customer = customerRepository.getCustomerById(id);

        if(customer.getChurnValue().compareTo(BigDecimal.valueOf(0.75))> 0) {
            applicationEventPublisher.publishEvent(new HighChurnEvent(customer));
        } else if (customer.getChurnValue().compareTo(BigDecimal.valueOf(0.50))> 0) {
            applicationEventPublisher.publishEvent(new MediumChurnEvent(customer));
        }

        return customerRepository.getCustomerById(id);
    }
}
