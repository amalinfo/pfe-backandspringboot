package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class AuthenticationResponse {
    private String accessToken;
    private List<String> roles;
}
