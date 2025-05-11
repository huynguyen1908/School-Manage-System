package org.example.service;

import org.example.dto.request.CreateFeedbackDTO;
import org.example.dto.request.CreateRequestDTO;
import org.example.dto.respone.RequestFeedbackDTO;
import org.example.entity.RequestFeedback;

import java.util.List;

public interface RequestFeedbackService {
    List<RequestFeedbackDTO> getRequestListByUserId(String userId);
    RequestFeedbackDTO getRequestById(String requestId);
    RequestFeedback createRequest(CreateRequestDTO dto);
    RequestFeedback sentFeedback(CreateFeedbackDTO dto);
}
