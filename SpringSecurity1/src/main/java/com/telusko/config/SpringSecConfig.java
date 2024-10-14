package com.telusko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf((csrf) -> csrf.ignoringRequestMatchers("/saveMsg")
//                .ignoringRequestMatchers("/public/**")
//                .ignoringRequestMatchers("/api/**")
//                .ignoringRequestMatchers("/data-api/**"));

//        http.authorizeHttpRequests((authz) -> authz
//                .requestMatchers("/api/addtelusko", "/api/updatetelusko", "/api/deletetelusko", "/public/**", "/api/**", "/data-api/**").permitAll()
//                .anyRequest().authenticated());
        http.csrf(customizer -> customizer.disable());//this will disable the csrf protection
        http.authorizeHttpRequests(author -> author.anyRequest().authenticated());// this will make any request authenticated
        //http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());// This will allow anyone to make a request
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
