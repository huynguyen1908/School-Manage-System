package org.example.service.impl;

import org.example.dto.request.CreateMessageRequest;
import org.example.dto.respone.MessageDTO;
import org.example.entity.Message;
import org.example.entity.UserAccount;
import org.example.mapper.MessageMapper;
import org.example.repository.MessageRepository;
import org.example.repository.UserAccountRepository;
import org.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<MessageDTO> getMessages(String senderId, String receiverId) {
        List<Message> messages = messageRepository.findBySender_UserIdAndReceiver_UserId(senderId, receiverId);
        return messages.stream()
                .map(messageMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDTO createMessage(CreateMessageRequest request) {
        UserAccount sender = userAccountRepository.findById(request.getSender())
                .orElseThrow(() -> new RuntimeException("Sender not found"));
        UserAccount receiver = userAccountRepository.findById(request.getReceiver())
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        Message message = new Message();
        message.setMessageId(UUID.randomUUID().toString());
        message.setContent(request.getContent());
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setSentAt(LocalDateTime.now());

        Message saved = messageRepository.save(message);
        return messageMapper.toDTO(saved);
    }

    @Override
    public List<MessageDTO> getConversation(String user1Id, String user2Id) {
        List<Message> conversation = messageRepository.findConversation(user1Id, user2Id);
        return conversation.stream()
                .map(messageMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMessage(String messageId) {
        messageRepository.deleteByMessageId(messageId);
    }
}
