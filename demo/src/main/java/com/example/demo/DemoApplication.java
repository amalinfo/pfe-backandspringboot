package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/*@Bean
	CommandLineRunner start(AccountService accountService) {
		return args->{
			accountService.addNewRole(new AppRole("ADMIN"));
			accountService.addNewRole(new AppRole("USER"));

			accountService.addNewRole(new AppRole("CUSTOMOR_MANAGER"));
			accountService.addNewRole(new AppRole("PRODUCT_MANAGER"));
			accountService.addNewRole(new AppRole("BILLS_MANAGER"));

	        accountService.addNewUser(new AppUser("admin@gmail.com","123456789", new ArrayList<>()));
			accountService.addNewUser(new AppUser("user1@gmail.com","1234567810", new ArrayList<>()));
			accountService.addNewUser(new AppUser("user2@gmail.com","1234567810", new ArrayList<>()));
			accountService.addNewUser(new AppUser("user3@gmail.com","12345678", new ArrayList<>()));
			accountService.addNewUser(new AppUser("user4@gmail.com","12345678", new ArrayList<>()));
	        accountService.addRolebyUser("admin@gmail.com", "ADMIN");
			accountService.addRolebyUser("user1@gmail.com", "USER");
			accountService.addRolebyUser("user2@gmail.com", "USER");
			accountService.addRolebyUser("user2@gmail.com", "CUSTOMOR_MANAGER");
			accountService.addRolebyUser("user3@gmail.com", "USER");
			accountService.addRolebyUser("user3@gmail.com", "PRODUCT_MANAGER");
			accountService.addRolebyUser("user4@gmail.com", "USER");
			accountService.addRolebyUser("user4@gmail.com", "BILLS_MANAGER");

		};

	}*/
}