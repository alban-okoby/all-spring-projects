package com.digitalsouag.redditapi.entity;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank(message = "required Username please!")
    private String username;
    @NotBlank(message = "required password please!")
    private String password;
    @Email @NotEmpty(message = "required email please!")
    private String email;
    @Timestamp
    private Instant registedAt;
    private Instant updatedAt;
    private boolean enabled;
}
