package org.example.service.impl;

import org.example.entity.RequestFeedback;
import org.example.repository.RequestFeedbackRepository;
import org.example.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestFeedbackService implements RequestService {
    @Autowired
    private RequestFeedbackRepository requestFeedbackRepository;

    public List<RequestFeedback> getAllRequests() {
        return requestFeedbackRepository.findAll();
    }

    public RequestFeedback saveRequest(RequestFeedback requestFeedback) {
        return requestFeedbackRepository.save(requestFeedback);
    }
}
