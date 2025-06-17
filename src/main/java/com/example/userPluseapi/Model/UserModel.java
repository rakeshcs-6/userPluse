package com.example.userPluseapi.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="user")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "password")
public class UserModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;


    @NotBlank
    private String name;


    @NotBlank
    @Email
    private  String email;

    @NotBlank
    private String password;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

}
