package com.hdc.zs.art.chat.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * Created by DELL(mxd) on 2021/1/22 21:27
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDatailsService;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDatailsService).passwordEncoder(password());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.logout()
                // 触发注销操作
                .logoutUrl("/loginOut")
                // 注销成功跳转页面
                .logoutSuccessUrl("/toLogin")
                // 指定是否在注销之后让Session失效
                .invalidateHttpSession(true);
        // 添加 权限不足的  提示页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        http.headers().frameOptions().disable();
        http.formLogin()
                // 前往登录页面
                .loginPage("/toLogin")
                // 登录需要提交的表单
                .loginProcessingUrl("/login") //请求路径
                // 登陆成功后 的 请求
                .defaultSuccessUrl("/user/home").permitAll()  //登陆成功跳转页面
                .and().authorizeRequests()
                .antMatchers("/zs/hello","/mxd/index").hasAnyRole("admin,user")  //拦截的请求  无效
                .anyRequest().authenticated()
                //关闭scrf
                .and().csrf().disable();
    }

    // 无实际作用  保留
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        // 建表语句   开启一次即可
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }
    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }


    /**
     *  重要  处理静态资源的
     * @param web 0
     * @throws Exception 0
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //配置静态文件不需要认证       以后的静态资源 都需要在这里添加
        web.ignoring()
                .antMatchers("/asserts/**","/asserts/**/**","/asserts/**/**/**"
                        ,"/css/**","/css/**/**","/js/**","/avatar/**","/fonts/**","/fonts/**/**",
                        "/image/**","/image/**/**","/layui/**","/layui/**/**","/layui/**/**/**",
                        "/script/**","/script/**/**","/script/**/**/**","/register1","/register","/userKeFu","/adminKeFu","/chat");
    }


}
