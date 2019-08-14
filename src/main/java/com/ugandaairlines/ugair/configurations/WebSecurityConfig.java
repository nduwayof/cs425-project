package com.ugandaairlines.ugair.configurations;

import com.ugandaairlines.ugair.security.domain.EUserRole;
import com.ugandaairlines.ugair.security.service.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsServiceImplementation;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsServiceImplementation, DataSource dataSource) {
        this.userDetailsServiceImplementation = userDetailsServiceImplementation;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsServiceImplementation)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .antMatchers("/web/**").permitAll()
                .antMatchers("/app/assets/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/booking/**").permitAll()
                .antMatchers("/administrator/login").permitAll()
                .antMatchers("/app/**").hasRole(EUserRole.ADMINISTRATOR.toString())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/administrator/login")
                .defaultSuccessUrl("/app/dashboard")
                .failureUrl("/administrator/login/failed")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/administrator/login?logout")
                .permitAll()
                .and()
                .exceptionHandling();
    }

}
