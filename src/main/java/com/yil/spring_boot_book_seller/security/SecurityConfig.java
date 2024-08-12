package com.yil.spring_boot_book_seller.security;

import com.yil.spring_boot_book_seller.model.Role;
import com.yil.spring_boot_book_seller.security.jwt.InternalApiAuthenticationFilter;
import com.yil.spring_boot_book_seller.security.jwt.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Value("${authentication.internal-api-key}")
    private String internalApiKey;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests(request->
            request.requestMatchers("/api/authentication/**").permitAll()
                    .requestMatchers("/api/internal/**").hasRole(Role.SYSTEM_MANAGER.name())
                    .requestMatchers(HttpMethod.GET,"/api/book/**").permitAll()
                    .requestMatchers("/api/book/**").hasRole(Role.ADMIN.name())
                    .anyRequest().authenticated());

        http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(internalApiAuthenticationFilter(), JwtAuthorizationFilter.class);
        return http.build();
    }
    @Bean
    public InternalApiAuthenticationFilter internalApiAuthenticationFilter()
    {
        return new InternalApiAuthenticationFilter(internalApiKey);
    }

    @Bean (BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter () {
        return new JwtAuthorizationFilter();
    }
}
