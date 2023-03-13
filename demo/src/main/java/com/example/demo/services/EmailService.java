package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender mailSender;
    public  void sendMail( String to, String pwd){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("savewaterwed321@gmail.com");
                message.setSubject("new password");
                message.setText(pwd);
                mailSender.send(message);



    }

}
