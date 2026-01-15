package com.notification.center.churnHistory;

import com.notification.center.customer.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "churn_history")
@Getter
@Setter
@ToString
public class ChurnHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request_id")
    private String requestId;

    @Column(name = "api_provider")
    private String apiProvider;

    @Column(name = "churn_score")
    private BigDecimal churnScore;

    @Column(name = "risk_level")
    private String riskLevel;

    @Column(name = "http_status")
    private BigDecimal httpStatus;

    @Column(name = "response_time_ms")
    private BigDecimal responseTimeMs;

    @Lob
    @Column(name = "raw_response")
    private String rawResponse;

    @Column(name = "requested_at")
    private LocalDateTime requestedAt;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
