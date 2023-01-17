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
@Table(name = "_privatemessage")
public class PrivateMessage {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private User sender;
    @ManyToOne
    private User receiver;
    private String content;

}
