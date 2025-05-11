package org.example.controller;

import org.example.dto.request.CreateNotificationRequest;
import org.example.dto.respone.NotificationDTO;
import org.example.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<NotificationDTO> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDTO> getNotificationContent(@PathVariable String id) {
        return ResponseEntity.ok(notificationService.getNotificationContent(id));
    }

    @PostMapping
    public ResponseEntity<NotificationDTO> createNotification(@RequestBody CreateNotificationRequest request) {
        NotificationDTO created = notificationService.createNotification(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<NotificationDTO>> getNotificationsOfUser(@PathVariable("id") String userid) {
        return ResponseEntity.ok().body(notificationService.getNotificationsOfUser(userid));
    }
}
