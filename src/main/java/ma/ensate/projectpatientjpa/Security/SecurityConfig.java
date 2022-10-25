package ma.ensate.projectpatientjpa.Security;


import ma.ensate.projectpatientjpa.Security.Service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;


    /*
        @Bean
        public InMemoryUserDetailsManager userDetailsManager(){
            PasswordEncoder passwordEncoder= passwordEncoder();
            UserDetails user= User.withUsername("admin2")
                    .password(passwordEncoder().encode("password"))
                    .roles("ADMIN")
                    .build();
            return new InMemoryUserDetailsManager(user);
        }

    */

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        // Configure AuthenticationManagerBuilder
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsServiceImpl);

         return http
                 .csrf(csrf-> csrf.disable())
                 .authorizeRequests( auth ->{

                     auth.antMatchers("/").permitAll();
                     auth.antMatchers("/formPatient" ,"/delete/**","/modifierPatient/**","/save/**").hasAuthority("ADMIN");
                     auth.antMatchers("/webjars/**").permitAll();
                     auth.anyRequest().authenticated();
                         })
                 .exceptionHandling().accessDeniedPage("/403")
                 .and()
                 .formLogin()
                  .and()
                 .httpBasic(Customizer.withDefaults())
                 .build();
    }


}
