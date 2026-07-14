package com.fw.custompos.configurations;

import com.fw.custompos.constants.ApiViewContracts;
import com.fw.custompos.constants.Roles;
import com.fw.custompos.entities.TempAccounts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(AuthenticationManagerBuilder builder) throws Exception {
    builder
        .inMemoryAuthentication()
        .withUser(TempAccounts.ACCOUNT1_EMAIL)
        .password(passwordEncoder().encode(TempAccounts.ACCOUNT1_PASSWORD))
        .roles(Roles.OWNER, Roles.STAFF)
        .and()
        .withUser(TempAccounts.ACCOUNT2_EMAIL)
        .password(passwordEncoder().encode(TempAccounts.ACCOUNT2_PASSWORD))
        .roles(Roles.STAFF);
  }

  @Override
  public void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .requiresChannel()
        .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
        .requiresSecure()
        .and()
        .httpBasic()
        .and()
        .csrf()
        .disable()
        .authorizeRequests()
        /** views */
        .antMatchers(ApiViewContracts.MENU + ApiViewContracts.LIST)
        .hasAnyRole(Roles.OWNER, Roles.STAFF)
        .antMatchers(ApiViewContracts.MENU + ApiViewContracts.CREATE)
        .hasAnyRole(Roles.OWNER)
        .antMatchers(ApiViewContracts.MENU + ApiViewContracts.UPDATE + "/**")
        .hasAnyRole(Roles.OWNER)
        .antMatchers(ApiViewContracts.ORDER + ApiViewContracts.LIST)
        .hasAnyRole(Roles.OWNER, Roles.STAFF)
        .antMatchers(ApiViewContracts.ORDER + ApiViewContracts.DETAILS + "/**")
        .hasAnyRole(Roles.OWNER, Roles.STAFF)
        .antMatchers(ApiViewContracts.ORDER + ApiViewContracts.CREATE)
        .hasAnyRole(Roles.OWNER, Roles.STAFF)
        .antMatchers(ApiViewContracts.ORDER_MENU + ApiViewContracts.CREATE + "/**")
        .hasAnyRole(Roles.OWNER, Roles.STAFF)
        .antMatchers(ApiViewContracts.TRANSACTION + ApiViewContracts.LIST)
        .hasAnyRole(Roles.OWNER, Roles.STAFF)
        .antMatchers(ApiViewContracts.TRANSACTION + ApiViewContracts.VIEW_RECEIPT + "/**")
        .hasAnyRole(Roles.OWNER, Roles.STAFF)
        /** APIs */
        .antMatchers(ApiViewContracts.API + ApiViewContracts.MENU + ApiViewContracts.CREATE)
        .hasAnyRole(Roles.OWNER)
        .antMatchers(ApiViewContracts.API + ApiViewContracts.MENU + ApiViewContracts.UPDATE)
        .hasAnyRole(Roles.OWNER)
        .antMatchers(ApiViewContracts.API + ApiViewContracts.MENU + ApiViewContracts.DELETE)
        .hasAnyRole(Roles.OWNER)
        .antMatchers(ApiViewContracts.API + ApiViewContracts.ORDER + ApiViewContracts.CREATE)
        .hasAnyRole(Roles.OWNER, Roles.STAFF)
        .antMatchers(ApiViewContracts.API + ApiViewContracts.ORDER + ApiViewContracts.DELETE)
        .hasAnyRole(Roles.OWNER, Roles.STAFF)
        .antMatchers(ApiViewContracts.API + ApiViewContracts.ORDER_MENU + ApiViewContracts.CREATE)
        .hasAnyRole(Roles.OWNER, Roles.STAFF)
        .antMatchers(ApiViewContracts.API + ApiViewContracts.ORDER_MENU + ApiViewContracts.DELETE)
        .hasAnyRole(Roles.OWNER, Roles.STAFF)
        .antMatchers(
            ApiViewContracts.API + ApiViewContracts.TRANSACTION + ApiViewContracts.SUBMIT_PAYMENT)
        .hasAnyRole(Roles.OWNER, Roles.STAFF)
        .and()
        .formLogin()
        .loginPage(ApiViewContracts.AUTH + ApiViewContracts.LOGIN);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
