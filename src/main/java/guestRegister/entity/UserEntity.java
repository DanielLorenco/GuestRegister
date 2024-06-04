package guestRegister.entity;

import jakarta.persistence.*;
import lombok.Data;

    @Entity(name = "user")
    @Data
    public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long userId;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(nullable = false)
        private String password;

        @Column(nullable = false)
        private boolean admin = false;


    }

