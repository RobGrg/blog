package com.example.authserver.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true, nullable = false)
    @NotEmpty(message = "Please provide a username.")
    @Size(min = 1, max = 100)
    private String userName;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "Please provide a email.")
    @Size(min = 1, max = 100)
    private String email;

    @NotEmpty(message = "Please provide a password.")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Role role;

}
