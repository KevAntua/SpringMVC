package com.mx.accenture.springmvc.ejemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/","/css/**","/js/**").permitAll()
                .antMatchers("/principal").hasAnyRole("USER")
                .and()
                    .authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .antMatchers("/listar").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
        
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
    
    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
        PasswordEncoder encoder = passwordEncoder();
        UserBuilder user = User.builder().passwordEncoder(encoder::encode);
        
        builder.inMemoryAuthentication()
                .withUser(user.username("admin").password("ACCENTURE").roles("ADMIN","USER"))
                .withUser(user.username("accesogeneral").password("ACCENTURE").roles("USER"));
    }

}
