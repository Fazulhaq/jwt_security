package com.example.jwtpractice;

import com.example.jwtpractice.auth.AuthenticationService;
import com.example.jwtpractice.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.jwtpractice.user.Role.ADMIN;
import static com.example.jwtpractice.user.Role.MANAGER;

@SpringBootApplication
public class JwtpracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtpracticeApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	){
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Fazulhaq")
					.lastname("Amin")
					.email("admin@yahoo.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin Token: " + service.register(admin).getAccessToken());
			var manager = RegisterRequest.builder()
					.firstname("Ahmad")
					.lastname("Yari")
					.email("manager@yahoo.com")
					.password("password")
					.role(MANAGER)
					.build();
			System.out.println("Manager Token: " + service.register(manager).getAccessToken());
		};

	}

}
