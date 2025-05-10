package org.example.controller;

import org.example.entity.Notification;
import org.example.entity.RequestFeedback;
import org.example.service.impl.NotificationService;
import org.example.service.impl.RequestFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class RequestController {
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private RequestFeedbackService requestFeedbackService;

    // Get list of notifications
    @GetMapping("/notifications")
    public ResponseEntity<List<Notification>> getNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    // Send new notification
    @PostMapping("/notifications")
    public ResponseEntity<Notification> sendNotification(@RequestBody Notification notification) {
        Notification savedNotification = notificationService.saveNotification(notification);
        return ResponseEntity.ok(savedNotification);
    }

    // Get list of requests/feedback
    @GetMapping("/requests")
    public ResponseEntity<List<RequestFeedback>> getRequests() {
        List<RequestFeedback> requests = requestFeedbackService.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    // Send new request/feedback
    @PostMapping("/request")
    public ResponseEntity<RequestFeedback> sendRequest(@RequestBody RequestFeedback requestFeedback) {
        RequestFeedback savedRequest = requestFeedbackService.saveRequest(requestFeedback);
        return ResponseEntity.ok(savedRequest);
    }
}
