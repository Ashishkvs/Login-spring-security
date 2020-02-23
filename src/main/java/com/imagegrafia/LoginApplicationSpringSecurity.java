package com.imagegrafia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.imagegrafia.repository.UserRepository;

@SpringBootApplication
public class LoginApplicationSpringSecurity {

	public static void main(String[] args) {
//		String encoded = new BCryptPasswordEncoder().encode("password");
//		System.out.println(encoded);
		SpringApplication.run(LoginApplicationSpringSecurity.class, args);
	}

}
