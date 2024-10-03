package com.demo.monolithic_security_security_product.config;

import com.demo.monolithic_security_security_product.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.swing.*;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService uds(PasswordEncoder pe){
//        UserDetails u1 = User.withUsername("achu")
//                .password(pe.encode("achu"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails u2 = User.withUsername("qwerty")
//                .password(pe.encode("qwerty"))
//                .roles("user")
//                .build();

        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder pe(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/swagger-ui/**","/h2-console/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .formLogin(Customizer.withDefaults())
                 .headers((headers) -> headers.frameOptions((frame) -> frame.sameOrigin()));

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticatedProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(uds(pe()));
        authenticationProvider.setPasswordEncoder(pe());
        return authenticationProvider;
    }

}
