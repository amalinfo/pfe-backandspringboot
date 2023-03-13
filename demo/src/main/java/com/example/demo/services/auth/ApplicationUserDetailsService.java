package com.example.demo.services.auth;

import com.example.demo.entities.AppUser;
import com.example.demo.repositories.AppUserRepo;
import com.example.demo.services.AccountService;
import com.example.demo.services.EmailService;
import com.example.demo.utils.ForgetPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class ApplicationUserDetailsService  implements UserDetailsService {
    @Autowired
    private AccountService accountService;
    @Autowired
     private AppUserRepo appUserRepo;
    @Autowired
    private EmailService emailService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appuser=accountService.loadUserByUsername(username);
        if(appuser==null) throw new UsernameNotFoundException("invalid user");
        Collection<GrantedAuthority> authorities=new ArrayList<>();

        appuser.getAppRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });

        return new User(appuser.getUsername(),appuser.getPassword(),authorities) ;
    }
    private String generate(){
        String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(ALPHA_NUMERIC_STRING.length());
            char character = ALPHA_NUMERIC_STRING.charAt(index);
            builder.append(character);
        }
        return builder.toString();
    }
  public ResponseEntity<?> forgetPassword(ForgetPassword request) {
         AppUser user=appUserRepo.findByEmail(request.getEmail());
         if(user!=null){
             String pwt=generate();
             BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
             user.setPassword(encoder.encode(pwt));

             appUserRepo.save(user);
             emailService.sendMail(user.getEmail(), pwt);
             return ResponseEntity.ok("OK");

         }
        return ResponseEntity.ok("User not found");
    }
}
