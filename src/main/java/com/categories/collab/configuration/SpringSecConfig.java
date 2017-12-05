package com.categories.collab.configuration;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

//@Configuration
public class SpringSecConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationProvider authenticationProvider;

    @Autowired
    @Qualifier("daoAuthenticationProvider")
    public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(UserDetailsService userDetailsService) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(encoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Autowired
    public void configureAuthManager(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests().antMatchers("/resources/**").permitAll()
                .and().authorizeRequests().antMatchers("/login**").permitAll()
                .and().authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();

        httpSecurity
                .authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .and().authorizeRequests().antMatchers("/api/**").access("hasRole('ROLE_USER')");

        httpSecurity
                .formLogin().loginPage("/login").loginProcessingUrl("/login.do")
                .defaultSuccessUrl("/category/", true)
                .failureUrl("/login?err=1")
                .usernameParameter("username").passwordParameter("password");

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
}