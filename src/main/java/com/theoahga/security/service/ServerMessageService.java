package com.theoahga.security.service;

import com.theoahga.security.entities.Server;
import com.theoahga.security.entities.ServerMessage;
import com.theoahga.security.entities.User;
import com.theoahga.security.repository.ServerMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ServerMessageService {
    private final ServerMessageRepository serverMessageRepository;

    public ServerMessage findById(Integer id){
        return serverMessageRepository.findById(id).orElseThrow(()-> new RuntimeException("No message was found!"));
    }

    public List<ServerMessage> findAllByServerAndSender(Server server, User sender){
        return serverMessageRepository.findAllByServerAndSender(server,sender).orElseThrow(()-> new RuntimeException("No message was found!"));
    }
    public List<ServerMessage> findAllByServer(Server server){
        return serverMessageRepository.findAllByServer(server).orElseThrow(()-> new RuntimeException("No message was found!"));
    }
}
