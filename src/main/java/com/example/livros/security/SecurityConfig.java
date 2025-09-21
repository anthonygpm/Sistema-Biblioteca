package com.example.livros.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                      // Swagger UI
                    .requestMatchers(
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger-resources/**",
                        "/webjars/**"
                    ).permitAll()

                      // Login
                    .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                    .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()

                      // Livros
                    .requestMatchers(HttpMethod.POST, "/livros/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/livros/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/livros/**").hasRole("ADMIN")

//                    // Autores
                    .requestMatchers(HttpMethod.POST, "/autores/**").hasAnyRole("EMPLOYEE", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/autores/**").hasAnyRole("EMPLOYEE", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/autores/**").hasRole("ADMIN")

//                    // Categorias
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

                    .anyRequest().authenticated()
            )
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
