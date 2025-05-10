package org.example.controller;

import org.example.service.impl.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class MessageController {

    // Giả lập cơ sở dữ liệu trong bộ nhớ
    private final List<MessageService> messages = new ArrayList<>();
    private Long currentId = 1L;

    // GET /message?sender_id=&receiver_id=
    @GetMapping("/message")
    public List<MessageService> getMessages(@RequestParam Long sender_id, @RequestParam Long receiver_id) {
        return messages.stream()
                .filter(msg -> msg.getSenderId().equals(sender_id) && msg.getReceiverId().equals(receiver_id))
                .collect(Collectors.toList());
    }

    // POST /message
    @PostMapping("/message")
    public MessageService sendMessage(@RequestBody MessageService newMessage) {
        newMessage.setId(currentId++);
        newMessage.setTimestamp(LocalDateTime.now());
        messages.add(newMessage);
        return newMessage;
    }

    // GET /messages/thread/{user1_id}/{user2_id}
    @GetMapping("/messages/thread/{user1_id}/{user2_id}")
    public List<MessageService> getConversation(@PathVariable Long user1_id, @PathVariable Long user2_id) {
        return messages.stream()
                .filter(msg ->
                        (msg.getSenderId().equals(user1_id) && msg.getReceiverId().equals(user2_id)) ||
                                (msg.getSenderId().equals(user2_id) && msg.getReceiverId().equals(user1_id))
                )
                .sorted(Comparator.comparing(MessageService::getTimestamp))
                .collect(Collectors.toList());
    }
}
