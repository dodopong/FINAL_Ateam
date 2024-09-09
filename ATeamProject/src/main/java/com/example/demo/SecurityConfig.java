package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	//실험
	   @Bean
	   SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	      // �씤利앸릺吏� �븡�� 紐⑤뱺 �럹�씠吏��쓽 �슂泥��쓣 �뿀�씫�븳�떎.
	      http
	      .authorizeHttpRequests(
	            (authorizeHttpRequests) -> authorizeHttpRequests
	           .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
	      	   .requestMatchers("/main").authenticated()) 
	        .csrf((csrf) -> csrf
	                .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
	        .headers((headers) -> headers
	                .addHeaderWriter(new XFrameOptionsHeaderWriter(
	                    XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
	        .formLogin((formLogin) -> formLogin
	              .loginPage("/user/login")
	              .defaultSuccessUrl("/main"))
	        .logout((logout) -> logout
	              .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
	              .logoutSuccessUrl("/main")
	              .invalidateHttpSession(true))
	      ;
	      return http.build();
	   }
	// �씠 �뙆�씪�� �봽濡쒖젥�듃�쓽 �떆�걧由ы떚 �꽕�젙�쓣 �떞�떦�븷 �삁�젙
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	AuthenticationManager authenticationManager(
			AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
