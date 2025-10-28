package cn.edu.bjut.librarymanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LibraryManagementSystemApplication {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        System.out.println('\n');
        SpringApplication.run(LibraryManagementSystemApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
