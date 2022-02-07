package com.example.communitywebservice.security;

import com.example.communitywebservice.user.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private Environment env;
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(Environment env, UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.env = env;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/users/**").permitAll();
//        http.authorizeRequests().antMatchers("/users/**")
//                        .hasIpAddress("172.30.1.56")
//                        .and()
//                        .addFilter(getAuthenticationFilter());
//
//        http.headers().frameOptions().disable();
    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception {

        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager(), userService, env);

        return authenticationFilter;
    }

}
