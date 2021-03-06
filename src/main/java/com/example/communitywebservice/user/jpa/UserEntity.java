package com.example.communitywebservice.user.jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userInfo")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String encryptedPwd;
    @Column(nullable = false)
    private String userNo;

}
