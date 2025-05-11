package org.example.controller;

import org.example.dto.request.CreateFeedbackDTO;
import org.example.dto.request.CreateRequestDTO;
import org.example.dto.respone.RequestFeedbackDTO;
import org.example.entity.RequestFeedback;
import org.example.service.RequestFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestFeedbackController {

    @Autowired
    private RequestFeedbackService service;

    @GetMapping("/requests/user/{id}")
    public ResponseEntity<List<RequestFeedbackDTO>> getRequestListByUserId(@PathVariable("id") String userId) {
        return ResponseEntity.ok(service.getRequestListByUserId(userId));
    }

    @GetMapping("/requests/{requestId}")
    public ResponseEntity<RequestFeedbackDTO> getRequestById(@PathVariable String requestId) {
        return ResponseEntity.ok(service.getRequestById(requestId));
    }

    @PostMapping("/createRequest")
    public ResponseEntity<RequestFeedback> createRequest(@RequestBody CreateRequestDTO dto) {
        return ResponseEntity.ok(service.createRequest(dto));
    }

    @PostMapping("/feedback")
    public ResponseEntity<RequestFeedback> sentFeedback(@RequestBody CreateFeedbackDTO dto) {
        return ResponseEntity.ok(service.sentFeedback(dto));
    }
}
