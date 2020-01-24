package org.javastart.zajecia31;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers("/login").permitAll()
                    .anyRequest().authenticated()
                .and()
//                .httpBasic();
                .formLogin()
                .and()
                .csrf().disable();
//                    .loginPage("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetails user = User.withUsername("Marcin")
                .password("{noop}password")
                .roles("USER")
                .build();
        auth.inMemoryAuthentication().withUser(user);
    }
}
