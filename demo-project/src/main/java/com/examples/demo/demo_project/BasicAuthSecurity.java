package com.examples.demo.demo_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableWebSecurity
public class BasicAuthSecurity {

  private final RestAuthenticationEntryPoint authenticationEntryPoint;

  @Autowired
  public BasicAuthSecurity(RestAuthenticationEntryPoint authenticationEntryPoint) {
    this.authenticationEntryPoint = authenticationEntryPoint;
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth,PasswordEncoder passwordEncoder) throws Exception {
    auth.inMemoryAuthentication()
            .passwordEncoder(PasswordEncoderConfig.passwordEncoder())
            .withUser("user1")
            .password(PasswordEncoderConfig.passwordEncoder().encode("password"))
            .roles("ADMIN");
  }

}