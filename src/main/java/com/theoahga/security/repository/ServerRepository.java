package com.theoahga.security.repository;

import com.theoahga.security.entities.Server;
import com.theoahga.security.entities.ServerMessage;
import com.theoahga.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServerRepository extends JpaRepository<Server,Integer> {
    Optional<List<Server>> findServerByName(String name);

}
