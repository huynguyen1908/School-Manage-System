package org.example.mapper;

import org.example.dto.respone.MessageDTO;
import org.example.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public MessageDTO toDTO(Message message) {
        MessageDTO dto = new MessageDTO();
        dto.setMessageId(message.getMessageId());
        dto.setContent(message.getContent());
        dto.setSenderId(message.getSender().getUserId());
        dto.setReceiverId(message.getReceiver().getUserId());
        dto.setSentAt(message.getSentAt());
        return dto;
    }
}
