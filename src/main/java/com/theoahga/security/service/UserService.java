package com.theoahga.security.service;

import com.theoahga.security.entities.PrivateMessage;
import com.theoahga.security.entities.Server;
import com.theoahga.security.entities.ServerMessage;
import com.theoahga.security.entities.User;
import com.theoahga.security.repository.PrivateMessageRepository;
import com.theoahga.security.repository.ServerMessageRepository;
import com.theoahga.security.repository.ServerRepository;
import com.theoahga.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ServerMessageRepository serverMessageRepository;
    private final PrivateMessageRepository privateMessageRepository;

    public User findUserById(Integer id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("The user was not found!"));
    }
    public User findServerByName(String name){
        return userRepository.findByUserName(name).orElseThrow(()-> new RuntimeException("The user was not found!"));
    }

    public User findServerByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("The user was not found!"));
    }
    public List<ServerMessage> findAllMessageOnServer(User user, Server server){
        return serverMessageRepository.findAllByServerAndSender(server,user).orElseThrow(()-> new RuntimeException("No message was found!"));
    }

}
