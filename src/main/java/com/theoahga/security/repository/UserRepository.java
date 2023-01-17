package com.theoahga.security.repository;

import java.util.Optional;

import com.theoahga.security.entities.Server;
import com.theoahga.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

  Optional<User> findByUserName(String userName);


}
