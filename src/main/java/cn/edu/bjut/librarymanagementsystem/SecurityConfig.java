package cn.edu.bjut.librarymanagementsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
public class SecurityConfig {
    //放行API接口
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/*",
                        "/api/borrows/user/*",
                        "/api/borrows/renew",
                        "/api/books/*",
                        "/api/seats/*",
                        "/api/seats/reservations/*",
                        "/api/seats/setMaintain/*",
                        "/api/seats/updateStatus/*").permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
