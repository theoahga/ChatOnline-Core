package com.theoahga.security.repository;

import com.theoahga.security.entities.PrivateMessage;
import com.theoahga.security.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PrivateMessageRepository extends JpaRepository<PrivateMessage, Integer> {
    Optional<List<PrivateMessage>> findMessagesBySenderAndReceiver(User sender, User receiver);

    Optional<List<PrivateMessage>> findMessagesBySender(User sender);

    Optional<List<PrivateMessage>> findMessagesByReceiver(User receiver);
}
