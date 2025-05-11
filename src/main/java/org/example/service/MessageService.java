package org.example.service;

import org.example.dto.request.CreateMessageRequest;
import org.example.dto.respone.MessageDTO;

import java.util.List;

public interface MessageService {
    List<MessageDTO> getMessages(String senderId, String receiverId);
    MessageDTO createMessage(CreateMessageRequest request);
    List<MessageDTO> getConversation(String user1Id, String user2Id);
    void deleteMessage(String messageId);
}
