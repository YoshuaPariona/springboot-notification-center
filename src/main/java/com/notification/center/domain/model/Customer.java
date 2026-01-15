package com.notification.center.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter
@Setter
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", unique = true, nullable = false)
    @Size(max = 50)
    private String externalId;

    @Column(name = "full_name", nullable = false)
    @Size(max = 150)
    private String fullName;

    @Column(nullable = false)
    @Size(max = 150)
    private String email;

    @Column(name = "market_segment")
    @Size(max = 30)
    private String marketSegment;

    @Column(nullable = false)
    @Size(max = 20)
    private String status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<ChurnHistory> churnHistoryList;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}
