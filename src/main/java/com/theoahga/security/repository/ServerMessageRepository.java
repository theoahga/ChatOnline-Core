package com.theoahga.security.repository;

import com.theoahga.security.entities.Server;
import com.theoahga.security.entities.ServerMessage;
import com.theoahga.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServerMessageRepository extends JpaRepository<ServerMessage,Integer> {
    Optional<List<ServerMessage>> findAllByServer(Server server);
    Optional<List<ServerMessage>> findAllByServerAndSender(Server server, User sender);
}
