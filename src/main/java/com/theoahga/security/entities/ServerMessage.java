package com.theoahga.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_servermessage")
public class ServerMessage {
    @Id
    @GeneratedValue
    private Integer id;
    private String content;
    @ManyToOne
    private Server server;

    @ManyToOne
    private User sender;

}
