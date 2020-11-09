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

                .antMatchers(HttpMethod.POST, "/category/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/category/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/category/read/**", "/category/list").hasRole(USER_ROLE)

                .antMatchers(HttpMethod.POST, "/promotion/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/promotion/read/**", "/promotion/list").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.DELETE,"/promotion/delete/**").hasRole(ADMIN_ROLE)

                .antMatchers(HttpMethod.POST, "/Employee/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/Employee/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/Employee/read/**", "/Employee/list/").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.POST, "/Job/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/Job/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/Job/read/**", "/Job/list/").hasRole(ADMIN_ROLE)

                .antMatchers(HttpMethod.POST, "/Product/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/Product/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/Product/read/**", "/Product/list/").hasRole(USER_ROLE)

                .antMatchers(HttpMethod.POST, "/stock/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/stock/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/stock/read/**", "/stock/all/").hasRole(USER_ROLE)

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
