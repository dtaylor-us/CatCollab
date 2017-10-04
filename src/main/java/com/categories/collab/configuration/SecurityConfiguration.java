package com.categories.collab.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataConfiguration dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        if (Constants.AUTH_METHOD.equals(Constants.AUTH_METHOD_IN_MEMORY)) {
            auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");
            auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
            auth.inMemoryAuthentication().withUser("dba").password("123").roles("DBA");
        } else if (Constants.AUTH_METHOD.equals(Constants.AUTH_METHOD_LDAP)) {
            auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
        } else if (Constants.AUTH_METHOD.equals(Constants.AUTH_METHOD_DATA_STORE)) {

            JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
            userDetailsService.setDataSource(dataSource.getDataSource());

            PasswordEncoder encoder = new BCryptPasswordEncoder();
            auth.userDetailsService(userDetailsService).passwordEncoder(encoder);

            auth.jdbcAuthentication().dataSource(dataSource.getDataSource());

            if (!userDetailsService.userExists("user")) {
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority("USER"));
                User userDetails = new User("user", encoder.encode("password"), authorities);

                userDetailsService.createUser(userDetails);
            }
        }

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        if (Constants.AUTH_METHOD.equals(Constants.AUTH_METHOD_IN_MEMORY)) {
            httpSecurity
                    .authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                    .and()
                    .authorizeRequests().antMatchers("/console/**").access("hasRole('ROLE_DBA')");
        } else if (Constants.AUTH_METHOD.equals(Constants.AUTH_METHOD_LDAP)) {
            httpSecurity.authorizeRequests().antMatchers("/resources/**").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/login**").permitAll()
                    .and()
                    .formLogin()
                    .and()
                    .logout()
                    .and()
                    .rememberMe();
        } else if (Constants.AUTH_METHOD.equals(Constants.AUTH_METHOD_DATA_STORE)) {
            httpSecurity
                    .authorizeRequests().antMatchers("/resources/**").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/login**").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();
            httpSecurity
                    .authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                    .and()
                    .authorizeRequests().antMatchers("/api/**").access("hasRole('ROLE_USER')");
            httpSecurity
                    .formLogin().loginPage("/login").loginProcessingUrl("/login.do")
                    .defaultSuccessUrl("/category/", true)
                    .failureUrl("/login?err=1")
                    .usernameParameter("username").passwordParameter("password");
            httpSecurity.csrf().disable();
            httpSecurity.headers().frameOptions().disable();
        } else if (Constants.AUTH_METHOD.equals(Constants.AUTH_METHOD_NONE)) {
            //permit everything with no authentication
            httpSecurity
                    .authorizeRequests().antMatchers("/").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/console/**").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/resources/**").permitAll();

            httpSecurity.csrf().disable();
            httpSecurity.headers().frameOptions().disable();
        }
    }

    @Bean
    public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
        ActiveDirectoryLdapAuthenticationProvider authProv =
                new ActiveDirectoryLdapAuthenticationProvider("domain", "ldap://xxx.xxx.xxx.xxx:389");

        authProv.setConvertSubErrorCodesToExceptions(true);
        authProv.setUseAuthenticationRequestCredentials(true);

        return authProv;
    }
}