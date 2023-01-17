package com.theoahga.security.service;

import com.theoahga.security.entities.PrivateMessage;
import com.theoahga.security.entities.User;
import com.theoahga.security.repository.PrivateMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PrivateMessageService {
    private final PrivateMessageRepository privateMessageRepository;

    public PrivateMessage findById(Integer id){
        return privateMessageRepository.findById(id).orElseThrow(()-> new RuntimeException("No message was found!"));
    }

    public List<PrivateMessage> listAll(){
        return privateMessageRepository.findAll();
    }

    public PrivateMessage send(PrivateMessage privateMessage){
        return privateMessageRepository.save(privateMessage);
    }
    public List<PrivateMessage> findMessagesSendedBy(User sender){
        return privateMessageRepository.findMessagesBySender(sender).orElseThrow(()-> new RuntimeException("No message was found!"));
    }
    public List<PrivateMessage> findMessagesReceivedBy(User receiver){
        return privateMessageRepository.findMessagesByReceiver(receiver).orElseThrow(()-> new RuntimeException("No message was found!"));
    }
    public List<PrivateMessage> findMessagesBySenderAndReceiver(User sender, User receiver){
        return privateMessageRepository.findMessagesBySenderAndReceiver(sender, receiver).orElseThrow(()-> new RuntimeException("No message was found!"));
    }

    public List<PrivateMessage> findAllMessageBetween(User user1,User user2){
        List<PrivateMessage> messages = new ArrayList<>();
        messages.addAll(privateMessageRepository.findMessagesBySenderAndReceiver(user1,user2).orElseThrow(()-> new RuntimeException("No message was found!")));
        messages.addAll(privateMessageRepository.findMessagesBySenderAndReceiver(user2,user1).orElseThrow(()-> new RuntimeException("No message was found!")));
        return messages;
    }
}
