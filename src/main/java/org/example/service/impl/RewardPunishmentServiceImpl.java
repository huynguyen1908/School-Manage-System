package org.example.service.impl;

import org.example.dto.request.CreateRewardPunishmentRequest;
import org.example.dto.respone.RewardPunishmentDTO;
import org.example.entity.RewardPunishment;
import org.example.entity.Student;
import org.example.entity.Teacher;
import org.example.enums.RewardPunishmentType;
import org.example.mapper.RewardPunishmentMapper;
import org.example.repository.RewardPunishmentRepository;
import org.example.repository.StudentRepository;
import org.example.repository.TeacherRepository;
import org.example.service.RewardPunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardPunishmentServiceImpl implements RewardPunishmentService {

    @Autowired
    private RewardPunishmentRepository rewardPunishmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public RewardPunishment createReward(CreateRewardPunishmentRequest request) {
        Student student = studentRepository.findById(request.getStudentId()).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        Teacher teacher = teacherRepository.findById(request.getTeacherId()).orElseThrow(() -> new IllegalArgumentException("Teacher not found"));

        RewardPunishment rewardPunishment = new RewardPunishment();
        rewardPunishment.setStudent(student);
        rewardPunishment.setTeacher(teacher);
        rewardPunishment.setContent(request.getContent());
        rewardPunishment.setStatus(request.getStatus());
        rewardPunishment.setSentAt(request.getSentAt());
        rewardPunishment.setType(RewardPunishmentType.REWARD);

        return rewardPunishmentRepository.save(rewardPunishment);
    }
    public RewardPunishment createPunishment(CreateRewardPunishmentRequest request) {
        Student student = studentRepository.findById(request.getStudentId()).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        Teacher teacher = teacherRepository.findById(request.getTeacherId()).orElseThrow(() -> new IllegalArgumentException("Teacher not found"));

        RewardPunishment rewardPunishment = new RewardPunishment();
        rewardPunishment.setStudent(student);
        rewardPunishment.setTeacher(teacher);
        rewardPunishment.setContent(request.getContent());
        rewardPunishment.setStatus(request.getStatus());
        rewardPunishment.setSentAt(request.getSentAt());
        rewardPunishment.setType(RewardPunishmentType.PUNISHMENT);

        return rewardPunishmentRepository.save(rewardPunishment);
    }
    @Override
    public List<RewardPunishmentDTO> getRewardList() {
        return rewardPunishmentRepository.findByType(RewardPunishmentType.REWARD)
                .stream()
                .map(RewardPunishmentMapper::toDTO)
                .toList();
    }
    @Override
    public RewardPunishmentDTO getRewardById(String id) {
        RewardPunishment reward = rewardPunishmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reward not found"));

        if (reward.getType() != RewardPunishmentType.REWARD) {
            throw new IllegalArgumentException("This is not a reward");
        }

        return RewardPunishmentMapper.toDTO(reward);
    }
    @Override
    public List<RewardPunishmentDTO> getPunishmentList() {
        return rewardPunishmentRepository.findByType(RewardPunishmentType.PUNISHMENT)
                .stream()
                .map(RewardPunishmentMapper::toDTO)
                .toList();
    }
    @Override
    public RewardPunishmentDTO getPunishmentById(String id) {
        RewardPunishment punishment = rewardPunishmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Punishment not found"));

        if (punishment.getType() != RewardPunishmentType.PUNISHMENT) {
            throw new IllegalArgumentException("This is not a punishment");
        }

        return RewardPunishmentMapper.toDTO(punishment);

    }

}
