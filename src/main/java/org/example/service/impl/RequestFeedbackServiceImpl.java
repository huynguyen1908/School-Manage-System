package org.example.service.impl;

import org.example.dto.request.CreateFeedbackDTO;
import org.example.dto.request.CreateRequestDTO;
import org.example.dto.respone.RequestFeedbackDTO;
import org.example.entity.RequestFeedback;
import org.example.enums.RequestStatus;
import org.example.enums.RequestType;
import org.example.entity.UserAccount;
import org.example.mapper.RequestFeedbackMapper;
import org.example.repository.RequestFeedbackRepository;
import org.example.repository.UserAccountRepository;
import org.example.service.RequestFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RequestFeedbackServiceImpl implements RequestFeedbackService {

    @Autowired
    private RequestFeedbackRepository repository;

    @Autowired
    private UserAccountRepository userRepo;

    @Autowired
    private RequestFeedbackMapper mapper;

    @Override
    public List<RequestFeedbackDTO> getRequestListByUserId(String userId) {
        return repository.findBySender_UserId(userId).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RequestFeedbackDTO getRequestById(String requestId) {
        RequestFeedback rf = repository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        return mapper.toDTO(rf);
    }

    @Override
    public RequestFeedback createRequest(CreateRequestDTO dto) {
        UserAccount sender = userRepo.findById(dto.getSenderId()).orElseThrow();
        UserAccount receiver = userRepo.findById(dto.getReceiverId()).orElseThrow();

        RequestFeedback rf = new RequestFeedback();
        rf.setRfId(UUID.randomUUID().toString());
        rf.setSender(sender);
        rf.setReceiver(receiver);
        rf.setContent(dto.getContent());
        rf.setType(RequestType.REQUEST);
        rf.setStatus(RequestStatus.PENDING);
        rf.setSendAt(LocalDateTime.now());

        return repository.save(rf);
    }

    @Override
    public RequestFeedback sentFeedback(CreateFeedbackDTO dto) {
        UserAccount sender = userRepo.findById(dto.getSenderId()).orElseThrow();
        UserAccount receiver = userRepo.findById(dto.getReceiverId()).orElseThrow();

        RequestFeedback rf = new RequestFeedback();
        rf.setRfId(UUID.randomUUID().toString());
        rf.setSender(sender);
        rf.setReceiver(receiver);
        rf.setContent(dto.getContent());
        rf.setType(RequestType.FEEDBACK);
        rf.setStatus(RequestStatus.DONE);
        rf.setSendAt(LocalDateTime.now());

        return repository.save(rf);
    }
}
