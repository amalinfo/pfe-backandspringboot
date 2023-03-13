package com.example.demo.controller;

import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.services.EmailService;
import com.example.demo.services.auth.ApplicationUserDetailsService;
import com.example.demo.utils.ForgetPassword;
import com.example.demo.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("auth")
@CrossOrigin("http://localhost:4200/")
@Slf4j
public class AuthenticationController {
@Autowired
private EmailService emailService;
    private AuthenticationManager authenticationManager;
    private ApplicationUserDetailsService userDetailsService;
    private JwtUtil jwtUtil;

    public AuthenticationController(AuthenticationManager authenticationManager, ApplicationUserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest)
    {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getLogin() , authenticationRequest.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getLogin()) ;
        log.info(userDetails.toString());
        final String jwt = jwtUtil.generateToken((User) userDetails);
        log.info(jwt.toString());
        List<String> roles = new ArrayList<>();
        userDetails.getAuthorities().forEach(
                elem -> roles.add(elem.getAuthority())
        );

        return ResponseEntity.ok(
                AuthenticationResponse.builder()
                        .accessToken(jwt)
                        .roles(roles)
                        .build()
        );

    }
    @PostMapping("password")
    public ResponseEntity<?>forgetPassword(@RequestBody() ForgetPassword email){

        return userDetailsService.forgetPassword(email);
    }

}
