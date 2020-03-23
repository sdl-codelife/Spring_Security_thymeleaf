package com.sdl.xadmin.security.config;

import com.sdl.xadmin.security.DynamicPermission;
import com.sdl.xadmin.security.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// 开启 Security
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private MyUserDetailService userDetailService;
    @Autowired
    private DynamicPermission dynamicPermission;

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略静态资源拦截
        web.ignoring().antMatchers("/css/**","/js/**","/images/**","/fonts/**","/lib/**","/login","/verifycode");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable() //关闭的csrf保护
               .headers().frameOptions().sameOrigin()//允许iframe frame加载同源的资源
               .and()
               .authorizeRequests()
               .antMatchers(HttpMethod.POST,"/user/register").permitAll()//无条件允许访问
               .anyRequest().access("@dynamicPermission.checkPermission(request,authentication)")//动态匹配菜单权限
               .and()
               .exceptionHandling().accessDeniedPage("/403")//无权限跳转
               .and()
               .formLogin().loginProcessingUrl("/dologin").loginPage("/login").successForwardUrl("/index").failureUrl("/login?error=true")
               .permitAll()
               .and()
               .logout().logoutUrl("/dologout").invalidateHttpSession(true).logoutSuccessUrl("/login");

    }

    /**
     * 身份认证接口
     * 自定义userDetailService
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);
    }

    /**
     * 强散列哈希加密实现
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
