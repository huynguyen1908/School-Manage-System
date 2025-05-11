package org.example.controller;

import org.example.dto.request.CreateMessageRequest;
import org.example.dto.respone.MessageDTO;
import org.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity<List<MessageDTO>> getMessages(
            @RequestParam String senderId,
            @RequestParam String receiverId) {
        return ResponseEntity.ok(messageService.getMessages(senderId, receiverId));
    }

    @PostMapping
    public ResponseEntity<MessageDTO> createMessage(@RequestBody CreateMessageRequest request) {
        MessageDTO created = messageService.createMessage(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/thread/{user1Id}/{user2Id}")
    public ResponseEntity<List<MessageDTO>> getConversation(
            @PathVariable String user1Id,
            @PathVariable String user2Id) {
        return ResponseEntity.ok(messageService.getConversation(user1Id, user2Id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable String id) {
        messageService.deleteMessage(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Message deleted successfully");
    }
}
