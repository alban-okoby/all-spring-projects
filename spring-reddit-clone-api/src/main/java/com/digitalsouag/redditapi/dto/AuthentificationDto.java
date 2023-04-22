package com.digitalsouag.redditapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthentificationDto {
    private String authentificationToken;
    private String username;
}
