package org.example.dto.request;

import java.time.LocalDateTime;

public class CreateRewardPunishmentRequest {
    private String decidedById;
    private String studentId;
    private String teacherId;
    private String content;
    private String description;
    private LocalDateTime effectiveDate;
    private String status;
    private String type;
    
    // Basic getters and setters
    public String getDecidedById() { return decidedById; }
    public void setDecidedById(String decidedById) { this.decidedById = decidedById; }
    
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    
    public String getTeacherId() { return teacherId; }
    public void setTeacherId(String teacherId) { this.teacherId = teacherId; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public LocalDateTime getEffectiveDate() { return effectiveDate; }
    public void setEffectiveDate(LocalDateTime effectiveDate) { this.effectiveDate = effectiveDate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
