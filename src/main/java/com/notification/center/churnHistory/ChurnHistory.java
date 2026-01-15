package com.notification.center.churnHistory;

import com.notification.center.customer.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
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
    @Size(max = 64)
    private String requestId;

    @Column(name = "api_provider")
    @Size(max = 50)
    private String apiProvider;

    @Column(name = "churn_score")
    @Digits(integer = 5, fraction = 2)
    private BigDecimal churnScore;

    @Column(name = "risk_level")
    @Size(max = 20)
    private String riskLevel;

    @Column(name = "http_status")
    @Min(100)
    @Max(999)
    private Integer httpStatus;

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
