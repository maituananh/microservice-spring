package com.anhmt.user_service.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "users")
@Table(name = "users", schema = "mcs-user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    UUID id;

    @Column(unique = true)
    String username;
}
