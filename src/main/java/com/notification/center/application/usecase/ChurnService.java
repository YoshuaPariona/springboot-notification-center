package com.notification.center.application.usecase;

import com.notification.center.application.dto.ChurnRequest;
import com.notification.center.application.dto.ChurnResponse;
import com.notification.center.application.dto.ExternalRequest;
import com.notification.center.application.dto.ExternalResponse;
import com.notification.center.domain.model.ChurnHistory;
import com.notification.center.domain.model.Customer;
import com.notification.center.domain.repository.ChurnRepository;
import com.notification.center.domain.repository.CustomerRepository;
import com.notification.center.infrastructure.client.FalseApiChurnClient;
import com.notification.center.infrastructure.event.HighChurnEvent;
import com.notification.center.infrastructure.event.MediumChurnEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class ChurnService {

    private final FalseApiChurnClient falseApiChurnClient;
    private final ChurnRepository churnRepository;
    private final CustomerRepository customerRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public ChurnService(FalseApiChurnClient falseApiChurnClient, ChurnRepository churnRepository, CustomerRepository customerRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.falseApiChurnClient = falseApiChurnClient;
        this.churnRepository = churnRepository;
        this.customerRepository = customerRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Transactional
    public ChurnResponse getChurn(ChurnRequest request) {

        ExternalRequest exRequest = request.externalRequest();
        ExternalResponse exResponse = falseApiChurnClient.predictChurn(exRequest);

        Customer customer = getCustomer(request, exRequest);
        ChurnHistory churnHistory = getChurnHistory(exResponse, customer);

        customerRepository.save(customer);
        churnRepository.save(churnHistory);

        publishEvent(customer, exResponse);

        return new ChurnResponse(
                request.externalId(),
                churnHistory.getRequestedAt(),
                exResponse.churnScore(),
                exResponse.riskLevel()
        );
    }

    private Customer getCustomer(ChurnRequest request, ExternalRequest exRequest) {
        if(customerRepository.findCustomerByExternalId(request.externalId()) != null) {
            return customerRepository.findCustomerByExternalId(request.externalId());
        }
        return new Customer(
                request.externalId(),
                request.fullName(),
                request.email(),
                exRequest.marketSegment(),
                exRequest.status()
        );
    }

    private ChurnHistory getChurnHistory(
            ExternalResponse exResponse,
            Customer customer) {
        return new ChurnHistory(
                exResponse.requestId(),
                "FastApi-v4",
                exResponse.churnScore(),
                exResponse.riskLevel(),
                200,
                125L,
                "rawResponse=> mucho texto",
                customer

        );
    }

    private void publishEvent(Customer customer, ExternalResponse exResponse) {
        if(exResponse.churnScore().compareTo(BigDecimal.valueOf(0.75))> 0) {
            applicationEventPublisher.publishEvent(new HighChurnEvent(customer, exResponse));
        } else if (exResponse.churnScore().compareTo(BigDecimal.valueOf(0.50))> 0) {
            applicationEventPublisher.publishEvent(new MediumChurnEvent(customer, exResponse));
        }
    }
}
