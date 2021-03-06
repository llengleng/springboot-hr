package com.niit.springboothr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.springboothr.filter.LoginFilter;
import com.niit.springboothr.model.Hr;
import com.niit.springboothr.model.RespBean;
import com.niit.springboothr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Lenovo
 * @date : 2020/4/16 08：47
 * @description :
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private HrService hrService;

    @Bean
    PasswordEncoder passwordEncoder(){
        //密码加密
        return new BCryptPasswordEncoder();
    }

    @Bean
    LoginFilter login() throws Exception{
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                Hr hr = (Hr) authentication.getPrincipal();
                hr.setPassword(null);
                RespBean ok = RespBean.ok("登录成功",hr);
                out.write(new ObjectMapper().writeValueAsString(ok)); //jackson的
                out.flush();
                out.close();
            }
        });
        loginFilter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out=response.getWriter();
                RespBean respBean = RespBean.error("登录失败");
                if (e instanceof LockedException){
                    respBean.setMsg("账户被锁定，登录失败");
                }else if (e instanceof BadCredentialsException){
                    respBean.setMsg("用户名或密码错误，登录失败");
                }else if (e instanceof DisabledException){
                    respBean.setMsg("账户被禁用，登录失败");
                }else if (e instanceof AccountExpiredException){
                    respBean.setMsg("账户过期，登录失败");
                }else if (e instanceof CredentialsExpiredException) {
                    respBean.setMsg("用户名或密码错误，登录失败");
                }
                out.write(new ObjectMapper().writeValueAsString(respBean));
                out.flush();
                out.close();
            }
        });
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        loginFilter.setFilterProcessesUrl("/doLogin");
        return loginFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(hrService);
    }

    // 不拦截 login
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/swagger-ui.html")
                .antMatchers("/v2/*")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/webjars/**")
                .antMatchers("/verifyCode")
                .mvcMatchers("/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.addFilterAt(login(), UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests()
//                .antMatchers("/swagger-ui.html").permitAll()
//                .antMatchers("/springfox-swagger-ui/**").permitAll()
//                .antMatchers("/api/**").authenticated()
                .anyRequest().authenticated()
                .and()
//                .formLogin()
//                .loginProcessingUrl("/doLogin")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .loginPage("/login")
//                .successHandler(new AuthenticationSuccessHandler() {
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
//                                                        HttpServletResponse response,
//                                                        Authentication authentication) throws IOException, ServletException {
//
//                    }
//                })
//                .failureHandler(new AuthenticationFailureHandler() {
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest request,
//                                                        HttpServletResponse response,
//                                                        AuthenticationException e) throws IOException, ServletException {
//
//                    }
//                })
//                .permitAll()
//                .and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write(new ObjectMapper().writeValueAsString(RespBean.ok("注销成功")));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .csrf().disable();
    }
}
