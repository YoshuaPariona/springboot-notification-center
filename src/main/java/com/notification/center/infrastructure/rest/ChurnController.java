package com.notification.center.infrastructure.rest;

import com.notification.center.application.dto.ChurnRequest;
import com.notification.center.application.dto.ChurnResponse;
import com.notification.center.application.usecase.ChurnService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/churn")
public class ChurnController {

    private final ChurnService churnService;

    public ChurnController(ChurnService churnService) {
        this.churnService = churnService;
    }

    @PostMapping("/predict")
    public ResponseEntity<ChurnResponse> getChurn(@RequestBody ChurnRequest request) {
        return ResponseEntity.ok(churnService.getChurn(request));
    }
}
