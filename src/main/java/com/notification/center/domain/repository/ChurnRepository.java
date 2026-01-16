package com.notification.center.domain.repository;

import com.notification.center.domain.model.ChurnHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChurnRepository extends JpaRepository<ChurnHistory, Long> {

    ChurnHistory findChurnHistoryByRequestId(String requestId);
}
