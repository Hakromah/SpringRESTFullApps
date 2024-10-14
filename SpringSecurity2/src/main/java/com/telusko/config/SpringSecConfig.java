package com.telusko.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecConfig {

    private UserDetailsService userDetailsService;

    public SpringSecConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

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

    //to get multiple users from the DB
    @Bean
    public AuthenticationProvider authProvider() {

        DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
        daoProvider.setUserDetailsService(userDetailsService);
        daoProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return daoProvider;
    }

    //We override UserDetailsService interface in other to implement multiple user details MANUALLY
//    @Bean
//    public UserDetailsService getUserDetailsService() {
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin123")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user1 = User.withDefaultPasswordEncoder()
//                .username("alien")
//                .password("alien123")
//                .roles("USER1")
//                .build();
//
//        UserDetails user2 = User.withDefaultPasswordEncoder()
//                .username("alieu")
//                .password("alieu123")
//                .roles("USER2")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(admin, user1, user2);
//    }
}
