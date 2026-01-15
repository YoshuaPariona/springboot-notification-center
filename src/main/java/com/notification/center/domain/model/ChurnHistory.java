package com.notification.center.domain.model;

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

    @Column(name = "request_id", unique = true, nullable = false)
    @Size(max = 64)
    private String requestId;

    @Column(name = "api_provider", nullable = false)
    @Size(max = 50)
    private String apiProvider;

    @Column(name = "churn_score")
    @Digits(integer = 3, fraction = 2)
    private BigDecimal churnScore;

    @Column(name = "risk_level", nullable = false)
    @Size(max = 20)
    private String riskLevel;

    @Column(name = "http_status", nullable = false)
    @Min(100)
    @Max(999)
    private Integer httpStatus;

    @Column(name = "response_time_ms")
    private Long responseTimeMs;

    @Lob
    @Column(name = "raw_response")
    private String rawResponse;

    @Column(name = "requested_at", nullable = false)
    private LocalDateTime requestedAt;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @ToString.Exclude
    private Customer customer;

    @PrePersist
    protected void onCreate() {
        this.requestedAt = LocalDateTime.now();
    }

}
