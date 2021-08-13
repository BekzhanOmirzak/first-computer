package springbootfirtst.springbootfistproject.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import springbootfirtst.springbootfistproject.service.AppUserService;

import static springbootfirtst.springbootfistproject.security.UserApplicationRole.*;

@Configuration
@EnableWebSecurity()
@AllArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final AppUserService appUserService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(daoAuthenticationProvider());
//                .withUser(
//                        User.builder().username("student")
//                                .password(passwordEncoder.encode("student"))
//                                .authorities(STUDENT.getGrantedAuthorities())
//                                .build()
//                )
//                .withUser(
//                        User.builder().username("admin")
//                                .password(passwordEncoder.encode("admin"))
//                                .authorities(ADMIN.getGrantedAuthorities())
//                                .build()
//                )
//                .withUser(
//                        User.builder().username("Linda")
//                                .password(passwordEncoder.encode("password"))
//                                .authorities(ADMIN.getGrantedAuthorities())
//                                .build()
//                )
//                .withUser(
//                        User.builder().username("Tom")
//                                .password(passwordEncoder.encode("tom"))
//                                .authorities(TRAINEE.getGrantedAuthorities())
//                                .build()
//                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/registration/**").permitAll()
                .antMatchers("/api/adm in").hasRole("ADMIN")
                .antMatchers("/api/user").hasRole("USER")
                .antMatchers("/api/student").hasRole("STUDENT")
                .antMatchers("/api/computer").hasRole("COMPUTER")
//                .antMatchers(HttpMethod.DELETE,"/management/api/people/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.POST,"/management/api/people/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT,"/management/api/people/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.GET,"/management/api/people/**").hasAnyRole(ADMIN.name(),TRAINEE.name() )
                .antMatchers("/api/person/**").hasRole(ADMIN.name())
                .antMatchers("/api/root").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().formLogin();
//
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(appUserService);

        return provider;
    }


}


