package com.yourname.onlineexamsystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.yourname.onlineexamsystem.repository")  // ✅ Исправлено!
public class OnlineExamSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlineExamSystemApplication.class, args);
	}
}

