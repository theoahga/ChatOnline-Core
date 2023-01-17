package com.theoahga.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_server")
public class Server {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany
    private List<User> users;

}
