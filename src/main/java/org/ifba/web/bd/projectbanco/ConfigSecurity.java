package org.ifba.web.bd.projectbanco;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)  
public class ConfigSecurity  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http//.csrf()
            //.disable()
            .authorizeRequests()
            //.antMatchers("/index")
            //.permitAll()
            //.antMatchers("/admin/**").hasRole("ADMIN")
            //.antMatchers("/anonymous*").anonymous()
            //.antMatchers("/login*").permitAll()
            .anyRequest().authenticated()
            .and()
            .oauth2Login().defaultSuccessUrl("/")
            .and().exceptionHandling().accessDeniedPage("/");
    }

}
