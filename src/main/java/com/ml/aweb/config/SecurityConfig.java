package com.ml.aweb.config;

import com.ml.aweb.filter.VerifyCodeFilter;
import com.ml.aweb.service.CustomerUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hanjiawei
 * @date 2020-09-25
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    VerifyCodeFilter verifyCodeFilter;
    //登陆配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class);

        http.authorizeRequests()
                .antMatchers("/js/**","/img/**","/css/**","/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/fore/login")
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.write("success");
                        out.flush();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.write("fail");
                        out.flush();
                    }
        })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        out.write("logout success");
                        out.flush();
                    }
                })
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    // 内置用户
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = passwordEncoder();
        System.out.println("=============================================");
        System.out.println(passwordEncoder.encode("123456"));
        System.out.println("=============================================");

        auth.userDetailsService(customUserService()).passwordEncoder(passwordEncoder);
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("sqlboy").roles("admin").password(passwordEncoder.encode("123456"))
                .and().withUser("javaboy").roles("user").password("$2a$10$OR3VSksVAmCzc.7WeaRPR.t0wyCsIj24k0Bne8iKWV1o.V9wsP8Xe");
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService customUserService() { // 注册UserDetailsService 的bean
        return new CustomerUserDetailService();
    }
}
