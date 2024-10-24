package com.example.demo.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,name = "full_name")
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(name = "users_roles",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private List <Role> roles;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Level level;

    @OneToMany(mappedBy = "author")
    private List<Comments> comments;

    @OneToMany(mappedBy = "author")
    private List <Route> routes;

    @OneToMany(mappedBy = "author")
    private List<Pictures> pictures;

    @OneToMany(mappedBy = "author")
    private List<Messages> sentMessages;

    @OneToMany(mappedBy = "recipient")
    private List<Messages> receivedMessages;
}
