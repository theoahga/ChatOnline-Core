package com.theoahga.security.controller;

import com.theoahga.security.controller.requestObject.MessageRequest;
import com.theoahga.security.entities.PrivateMessage;
import com.theoahga.security.entities.User;
import com.theoahga.security.service.PrivateMessageService;
import com.theoahga.security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/message")
public class MessageController {

  private final PrivateMessageService privateMessageService;
  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<PrivateMessage>> getAll() {
    return ResponseEntity.ok(privateMessageService.listAll());
  }
  @GetMapping("/sended")
  public ResponseEntity<List<PrivateMessage>> findMessagesSendedBy(@RequestBody String senderUsername) {
    return ResponseEntity.ok(privateMessageService.findMessagesSendedBy(userService.findServerByName(senderUsername)));
  }
  @GetMapping("/received")
  public ResponseEntity<List<PrivateMessage>> findMessagesReceivedBy(@RequestBody String receiverUsername) {
    return ResponseEntity.ok(privateMessageService.findMessagesReceivedBy(userService.findServerByName(receiverUsername)));
  }

  @GetMapping("/test")
  public ResponseEntity<List<PrivateMessage>> findMessagesBetween(@RequestBody String Username1 ,@RequestBody String Username2  ){
    return ResponseEntity.ok(privateMessageService.findAllMessageBetween(userService.findServerByName(Username1),userService.findServerByName(Username2)));
  }

  @PostMapping("/test2")
  public ResponseEntity<PrivateMessage> postmessage(@RequestBody MessageRequest m){
    PrivateMessage message = new PrivateMessage();
    message.setSender(userService.findServerByName(m.getSenderUsername()));
    message.setReceiver(userService.findServerByName(m.getReceiverUsername()));
    message.setContent(m.getContent());
    privateMessageService.send(message);
    return ResponseEntity.ok(message);
  }
}
