package org.example.repository;

import org.example.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, String> {

    List<Message> findBySender_UserIdAndReceiver_UserId(String senderId, String receiverId);

    @Query("SELECT m FROM Message m WHERE " +
            "(m.sender.userId = :user1 AND m.receiver.userId = :user2) " +
            "OR (m.sender.userId = :user2 AND m.receiver.userId = :user1) " +
            "ORDER BY m.sentAt ASC")
    List<Message> findConversation(String user1, String user2);
    void deleteByMessageId(String messageId);
}
