package org.example.controller;

import org.example.entity.Notification;
import org.example.entity.RequestFeedback;
import org.example.service.impl.NotificationServiceImpl;
import org.example.service.impl.RequestFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestController {

    @Autowired
    private RequestFeedbackService requestFeedbackService;

    @GetMapping("/requests")
    public ResponseEntity<List<RequestFeedback>> getRequests() {
        List<RequestFeedback> requests = requestFeedbackService.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    @PostMapping("/request")
    public ResponseEntity<RequestFeedback> sendRequest(@RequestBody RequestFeedback requestFeedback) {
        RequestFeedback savedRequest = requestFeedbackService.saveRequest(requestFeedback);
        return ResponseEntity.ok(savedRequest);
    }
}
