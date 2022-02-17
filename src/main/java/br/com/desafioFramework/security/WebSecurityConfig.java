/**
 *
 */
/*
 * package br.com.desafioFramework.security;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.security.config.annotation.method.configuration.
 * EnableGlobalMethodSecurity; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 * 
 *//**
	 * @author Felipe Dias
	 *
	 *//*
		 * @Configuration
		 * 
		 * @EnableWebSecurity
		 * 
		 * @EnableGlobalMethodSecurity(prePostEnabled = true) public class
		 * WebSecurityConfig extends WebSecurityConfigurerAdapter{
		 * 
		 * 
		 * 
		 * @Bean public BCryptPasswordEncoder encoder() { return new
		 * BCryptPasswordEncoder(); }
		 * 
		 * // @Override // protected void configure(AuthenticationManagerBuilder auth)
		 * throws Exception { // auth // .userDetailsService(usuarioService) //
		 * .passwordEncoder(passsordEncoder()); // }
		 * 
		 * 
		 * @Bean public AuthenticationManager authenticationManager() throws Exception {
		 * return super.authenticationManager(); }
		 * 
		 * 
		 * @Override protected void configure(HttpSecurity http) throws Exception {
		 * http.headers().frameOptions().disable(); http.cors().and().csrf().disable()
		 * //.addFilterAfter(new JWTFilter(),
		 * UsernamePasswordAuthenticationFilter.class) .authorizeRequests()
		 * .antMatchers(HttpMethod.POST, "/api/login").permitAll()
		 * .antMatchers(HttpMethod.POST, "/api/usuario").permitAll()
		 * .antMatchers(HttpMethod.POST, "/api/post").hasAnyRole("USUARIO",
		 * "ADMINISTRADOR") .antMatchers(HttpMethod.GET,
		 * "/api/usuario").hasAnyRole("USUARIO", "ADMINISTRADOR")
		 * .antMatchers(HttpMethod.GET, "/api/post").hasAnyRole("USUARIO",
		 * "ADMINISTRADOR") .antMatchers(HttpMethod.DELETE,
		 * "/api/post").hasAnyRole("USUARIO", "ADMINISTRADOR")
		 * .antMatchers("/administrador").hasAnyRole("ADMINISTRADOR")
		 * .anyRequest().authenticated() .and().cors().and().csrf().disable()
		 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 * }
		 * 
		 * 
		 * }
		 */