package com.furnitureapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN_ROLE = "ADMIN";
    private static final String USER_ROLE = "USER";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/sale/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/sale/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/sale/read/**", "/sale/all/").hasRole(USER_ROLE)
<<<<<<< HEAD
                .antMatchers(HttpMethod.POST, "/customer/**").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.DELETE, "/customer/delete/**").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET, "/customer/read/**", "/customer/all/").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.POST, "/appointment/**").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.DELETE, "/appointment/delete/**").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET, "/appointment/read/**", "/appointment/all/").hasRole(USER_ROLE)
=======
                .antMatchers(HttpMethod.POST, "/promotion/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/promotion/read/**", "/promotion/list").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.DELETE,"/promotion/delete/**").hasRole(ADMIN_ROLE)
>>>>>>> 132878294114b1f8a93920e681e235b6401218bd
                .and()
                .formLogin().disable()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("manager")
                .password(new BCryptPasswordEncoder().encode("admin-password"))
                .roles(ADMIN_ROLE, USER_ROLE)
                .and()
                .withUser("random-client")
                .password(new BCryptPasswordEncoder().encode("user-password"))
                .roles(USER_ROLE)
                .and()
                .withUser("random-employee")
                .password(new BCryptPasswordEncoder().encode("employee-password"))
                .roles(USER_ROLE);

    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
