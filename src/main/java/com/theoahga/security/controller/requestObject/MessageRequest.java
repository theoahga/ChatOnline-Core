package com.theoahga.security.controller.requestObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MessageRequest {
    private String senderUsername;
    private String receiverUsername;
    private String content;
}
