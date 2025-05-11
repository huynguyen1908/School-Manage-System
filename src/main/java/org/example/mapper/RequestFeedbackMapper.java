package org.example.mapper;

import org.example.dto.respone.RequestFeedbackDTO;
import org.example.entity.RequestFeedback;
import org.springframework.stereotype.Component;

@Component
public class RequestFeedbackMapper {
    public RequestFeedbackDTO toDTO(RequestFeedback rf) {
        RequestFeedbackDTO dto = new RequestFeedbackDTO();
        dto.setRfId(rf.getRfId());
        dto.setSenderId(rf.getSender().getUserId());
        dto.setReceiverId(rf.getReceiver().getUserId());
        dto.setContent(rf.getContent());
        dto.setStatus(rf.getStatus().name());
        dto.setType(rf.getType().name());
        dto.setSendAt(rf.getSendAt());
        return dto;
    }
}
