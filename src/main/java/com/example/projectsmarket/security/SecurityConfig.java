package com.example.projectsmarket.security;

import com.example.projectsmarket.entities.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/resources/**").permitAll()
                        .requestMatchers("/static/**").permitAll()
                        .requestMatchers("/projects").hasRole(Position.TEACHER.name())
                        .requestMatchers("/projects").hasRole(Position.ADMIN.name())
                        .requestMatchers("/projects/mark").hasRole(Position.TEACHER.name())
                        .requestMatchers("/projects/delete").hasRole(Position.ADMIN.name())
                        .requestMatchers("/projects/project").hasRole(Position.STUDENT.name())
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .successForwardUrl("/success")
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/login")
                        .permitAll()
                );

        return http.build();
    }

//    @Bean
//    protected void configure(HttpSecurity http) throws Exception {
//        http
////                .anonymous();
//                .csrf().disable()
//                .authorizeRequests()
////                .antMatchers(staticResources).permitAll()
//                .antMatchers("/**", "/resources/**")
//                .hasAnyAuthority()
//                .anyRequest().authenticated()
//                .antMatchers("/**/mark")
//                .hasRole(Position.TEACHER.name())
//                .anyRequest().authenticated()
//                .antMatchers("/**/delete")
//                .hasRole(Position.ADMIN.name())
//                .anyRequest().authenticated()
//                .antMatchers("/**/project")
//                .hasRole(Position.STUDENT.name())
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .defaultSuccessUrl("/success")
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .deleteCookies("JSESSIONID")
//                .logoutSuccessUrl("/auth/login");
//    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
//
//    @Override
//    public void configure(WebSecurity web) {
//        web
//                .ignoring()
//                .antMatchers("/resources/**");
//    }


    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        var daoAuthProvider = new DaoAuthenticationProvider();
        daoAuthProvider.setPasswordEncoder(new BCryptPasswordEncoder(10));
        daoAuthProvider.setUserDetailsService(userDetailsService);
        return daoAuthProvider;
    }
}
