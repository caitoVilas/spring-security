package com.caito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	/*@Autowired
	PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner createPasswords(){
		return args -> {
			System.out.println(passwordEncoder.encode("caito"));
			System.out.println(passwordEncoder.encode("rosy"));
		};
	}*/

}
