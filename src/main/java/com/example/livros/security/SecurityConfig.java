package com.example.livros.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                    // Livros
                    .requestMatchers(HttpMethod.GET, "/livros/**").permitAll() // qualquer um pode listar
                    .requestMatchers(HttpMethod.POST, "/livros/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/livros/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/livros/**").hasRole("ADMIN")

//                    // Autores
                    .requestMatchers(HttpMethod.GET, "/autores/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/autores/**").hasAnyRole("EMPLOYEE", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/autores/**").hasAnyRole("EMPLOYEE", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/autores/**").hasRole("ADMIN")

//                    // Categorias
                    .requestMatchers(HttpMethod.GET, "/categorias/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/categorias/**").hasAnyRole("EMPLOYEE", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/categorias/**").hasAnyRole("EMPLOYEE", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/categorias/**").hasRole("ADMIN")

//                    // Empréstimos
                    .requestMatchers(HttpMethod.GET, "/emprestimos/**").hasAnyRole("EMPLOYEE", "ADMIN")
                    .requestMatchers(HttpMethod.POST, "/emprestimos/**").hasAnyRole("USER", "EMPLOYEE", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/emprestimos/**").hasAnyRole("USER", "EMPLOYEE", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/emprestimos/**").hasRole("ADMIN")

//                    // Usuários
                    .requestMatchers("/usuarios/**").hasRole("ADMIN")

                    .requestMatchers(
                            "/swagger-ui/**",
                            "/v3/api-docs/**",
                            "/swagger-resources/**"
                    ).permitAll()

                    .anyRequest().permitAll()
            )
            .httpBasic(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
