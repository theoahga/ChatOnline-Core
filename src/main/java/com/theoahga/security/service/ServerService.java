package com.theoahga.security.service;

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
public class ServerService {
    private final ServerRepository serverRepository;
    private final ServerMessageRepository serverMessageRepository;

    public Server findServerById(Integer id){
        return serverRepository.findById(id).orElseThrow(()->new RuntimeException("The server was not found!"));
    }
    public List<Server> findServerByName(String serverName){
        return serverRepository.findServerByName(serverName).orElseThrow(()-> new RuntimeException("No server was found!"));
    }

    public List<ServerMessage> listAllMessages(Server server){
        return serverMessageRepository.findAllByServer(server).orElseThrow(()-> new RuntimeException("No message was found!"));
    }

    public List<ServerMessage> listAllMessagesFrom(Server server, User user){
        return serverMessageRepository.findAllByServerAndSender(server,user).orElseThrow(()-> new RuntimeException("No message was found!"));
    }

}
