package gr.uoa.di.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService mUserDetailsService;
    @Autowired
    private CustomSuccessHandler mCustomSuccessHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/assets/**").permitAll()
                .antMatchers("/profile").access("hasRole('PARENT') or hasRole('PROVIDER') or hasRole('ADMIN')")
                .antMatchers("/editprofile").access("hasRole('PARENT') or hasRole('PROVIDER') or hasRole('ADMIN')")
                .antMatchers("/editroles").access("hasRole('ADMIN')")
                .antMatchers("/create_event").access("hasRole('PROVIDER')")
                .antMatchers("/info").access("hasRole('PARENT') or hasRole('PROVIDER') or hasRole('ADMIN')")
                .antMatchers("/confirmation").access("hasRole('PARENT') or hasRole('PROVIDER') or hasRole('ADMIN')")
                .antMatchers("/admin").access("hasRole('ADMIN')")
                .antMatchers("/search_user").access("hasRole('ADMIN')")
                .antMatchers("/statistics").access("hasRole('ADMIN')")
                .and().formLogin().loginPage("/login").successHandler(mCustomSuccessHandler).usernameParameter("email").passwordParameter("password")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).deleteCookies("remember-me").logoutSuccessUrl("/").permitAll()
                .and().rememberMe().rememberMeParameter("remember")
                .and().csrf();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(mUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}