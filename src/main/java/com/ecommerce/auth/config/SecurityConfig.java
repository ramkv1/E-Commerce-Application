package com.ecommerce.auth.config;

//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//	
//	@Autowired
//	private InvalidUserAuthEntryPoint EntryPoint;
//	
//	
//	@Override
//	@Bean
//	protected AuthenticationManager authenticationManager() throws Exception{
//		return super.authenticationManager();
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
//		auth
//		.userDetailsService(userDetailsService)
//		.passwordEncoder(passwordEncoder);
//	}
//	
//	@Override
//	protected void configure (HttpSecurity http) throws Exception{
//		http
//		.csrf().disable()
//		.authorizeRequests()
//		.antMatchers("/user/save","/user/login").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.exceptionHandling()
//		.authenticationEntryPoint(EntryPoint)
//		.and()
//		.sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		/*.and()
//		//from Second Req on Words
//		.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
//		;*/
//	}
//	
//	/*@Bean
//	public AuthenticationManager authenticationManager() throws Exception{
//		return authenticationManager(); 
//	}
//	
//	@Bean
//	public void config(AuthenticationManagerBuilder auth) throws Exception{
//		auth.userDetailsService(userDetailsService)
//		.passwordEncoder(passwordEncoder);
//	}
//	
//	@Bean
//	public void configure(HttpSecurity http) throws Exception {
//		http
//		.csrf().disable()
//		.authorizeHttpRequests()
//		.requestMatchers("/user/save","/user/login").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.exceptionHandling()
//		.authenticationEntryPoint(EntryPoint)
//		.and()
//		.sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		//TODO : Verify user for Second req onwards...
//		;
//	}*/
// 
//}
//
//


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final InvalidUserAuthEntryPoint entryPoint;
    private final JwtAuthenticationFilter JwtAuthenticationFilter;;

    public SecurityConfig(UserDetailsService userDetailsService, 
                          BCryptPasswordEncoder passwordEncoder, 
                          InvalidUserAuthEntryPoint entryPoint,
                          JwtAuthenticationFilter JwtAuthenticationFilter) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.entryPoint = entryPoint;
        this.JwtAuthenticationFilter = JwtAuthenticationFilter;
    }

    // AuthenticationManager Bean
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    // SecurityFilterChain Bean
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/user/save", "/user/login").permitAll()
                .requestMatchers("/customer/create","/customer/get/**",
                		"/address/save","/address/get/**").authenticated()
                .anyRequest().authenticated()
            )
            .exceptionHandling(ex -> ex.authenticationEntryPoint(entryPoint))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(JwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        
        
        // Uncomment and add your filter if required
        // .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // AuthenticationManagerBuilder equivalent (configure authentication)
    @Bean
    public AuthenticationManagerResolver<AuthenticationManager> authenticationManagerResolver() {
        return authentication -> {
            try {
                AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder(null);
                auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
                return auth.build();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
