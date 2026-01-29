
INSERT INTO customer (external_id, full_name, email, market_segment, status, created_at, updated_at)
VALUES
    ('EXT-001', 'Juan Pérez García', 'juan.perez@example.com', 'PREMIUM', 'ACTIVE', TIMESTAMP '2025-01-01 08:00:00', TIMESTAMP '2025-01-15 10:30:00'),
    ('EXT-002', 'María López Sánchez', 'maria.lopez@example.com', 'STANDARD', 'ACTIVE', TIMESTAMP '2025-01-02 09:15:00', TIMESTAMP '2025-01-20 11:45:00'),
    ('EXT-003', 'Carlos Ramírez Torres', 'carlos.ramirez@example.com', 'BASIC', 'INACTIVE', TIMESTAMP '2025-01-03 10:30:00', TIMESTAMP '2025-01-25 14:00:00');

INSERT INTO churn_history (customer_id, request_id, api_provider, churn_score, risk_level, http_status, response_time_ms, raw_response, requested_at)
VALUES

    (1, 'req-20250110-001', 'PredictChurnAPI', 0.15, 'LOW', 200, 120, '{"churn_score": 0.15, "risk": "LOW", "recommendation": "No action needed"}', TIMESTAMP '2025-01-10 09:00:00'),
    (1, 'req-20250115-002', 'PredictChurnAPI', 0.22, 'MEDIUM', 200, 180, '{"churn_score": 0.22, "risk": "MEDIUM", "recommendation": "Monitor"}', TIMESTAMP '2025-01-15 10:00:00'),
    (1, 'req-20250120-003', 'PredictChurnAPI', 0.08, 'LOW', 200, 95, '{"churn_score": 0.08, "risk": "LOW", "recommendation": "No action needed"}', TIMESTAMP '2025-01-20 11:00:00'),

    (2, 'req-20250112-004', 'ChurnGuard', 0.78, 'HIGH', 200, 210, '{"churn_score": 0.78, "risk": "HIGH", "recommendation": "Immediate retention action"}', TIMESTAMP '2025-01-12 14:00:00'),
    (2, 'req-20250118-005', 'ChurnGuard', 0.65, 'HIGH', 200, 190, '{"churn_score": 0.65, "risk": "HIGH", "recommendation": "Contact customer"}', TIMESTAMP '2025-01-18 15:00:00'),
    (2, 'req-20250122-006', 'ChurnGuard', 0.55, 'MEDIUM', 200, 170, '{"churn_score": 0.55, "risk": "MEDIUM", "recommendation": "Offer discount"}', TIMESTAMP '2025-01-22 16:00:00'),

    (3, 'req-20250114-007', 'RetentionAI', 0.92, 'HIGH', 200, 250, '{"churn_score": 0.92, "risk": "HIGH", "recommendation": "Urgent retention campaign"}', TIMESTAMP '2025-01-14 17:00:00'),
    (3, 'req-20250119-008', 'RetentionAI', 0.88, 'HIGH', 200, 230, '{"churn_score": 0.88, "risk": "HIGH", "recommendation": "Personalized offer"}', TIMESTAMP '2025-01-19 18:00:00'),
    (3, 'req-20250124-009', 'RetentionAI', 0.95, 'HIGH', 200, 270, '{"churn_score": 0.95, "risk": "HIGH", "recommendation": "Win-back campaign"}', TIMESTAMP '2025-01-24 19:00:00');
