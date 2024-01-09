package com.projeto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.projeto.repository.UsuarioRepository;
import com.projeto.security.JWTAuthenticationFilter;
import com.projeto.security.JWTAuthorizationFilter;
import com.projeto.security.JWTUtil;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private UsuarioRepository cliRepo;

	private static final String[] PUBLIC_MATCHERS = {"/InformacoesEmpresas/**", "/os/**", "/tecnicos/**", "/categorias/**", "/gerentes/**",
			"/produtos/**",
			"/usuarios/**", "/servicos/**", "/acessorios/**", "/situacoes/**", "/clientes/**", "/documentacao/**",
			"/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html/**" };

	private static final String[] PUBLIC_MATCHERS_POST = {"/InformacoesEmpresas/**", "/os/**", "/tecnicos/**", "/categorias/**", "/gerentes/**",
			"/usuarios/**", "/acessorios/**", "/clientes/**", "/login/**", "/servicos/**", "/situacoes/**" };

	private static final String[] PUBLIC_MATCHERS_DELETE = {"/InformacoesEmpresas/**",  "/os/**", "/tecnicos/**", "/categorias/**", "/gerentes/**",
			"/usuarios/**", "/acessorios/**", "/clientes/**" , "/servicos/**", "/situacoes/**"};

	private static final String[] PUBLIC_MATCHERS_PUT = {"/InformacoesEmpresas/**",  "/os/**", "/tecnicos/**", "/categorias/**", "/gerentes/**",
			"/usuarios/**", "/acessorios/**", "/clientes/**", "/servicos/**", "/situacoes/**" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil, cliRepo));
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
		http.authorizeRequests().antMatchers(HttpMethod.GET, PUBLIC_MATCHERS).permitAll()
				.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
				.antMatchers(HttpMethod.PUT, PUBLIC_MATCHERS_PUT).permitAll()
				.antMatchers(HttpMethod.DELETE, PUBLIC_MATCHERS_DELETE).permitAll().anyRequest().authenticated();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH","HEAD","CONNECT","TRACE","OPTIONS"));
		corsConfig.addAllowedHeader("*");
		corsConfig.addAllowedOrigin("*");
		
		source.registerCorsConfiguration("/**", corsConfig);
		
		return source;
	}
	

}
