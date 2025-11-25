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
                        "/api/users/*",
                        "/api/users/update/*",
                        "/api/users/delete/*",
                        "/api/borrows/*",
                        "/api/borrows/user/*",
                        "/api/borrows/borrowed/*",
                        "/api/books/*",
                        "/api/books/searchTitle/*",
                        "/api/books/updateBook/*",
                        "/api/books/delete/*",
                        "/api/book-locations/*",
                        "/api/book-locations/book/*",
                        "/api/book-locations/update/*",
                        "/api/book-locations/delete/*",
                        "/api/book-reviews/*",
                        "/api/book-reviews/update/*",
                        "/api/book-reviews/delete/*",
                        "/api/book-reviews/user/*",
                        "/api/seats/*",
                        "/api/seats/reservations/*",
                        "/api/seats/reservations/user/*",
                        "/api/seats/reservations/checkin/*",
                        "/api/seats/setMaintain/*",
                        "/api/seats/toggleMaintain/*",
                        "/api/seats/updateStatus/*",
                        "/api/book-locations/book/*",
                        "/api/book-reviews/*").permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
