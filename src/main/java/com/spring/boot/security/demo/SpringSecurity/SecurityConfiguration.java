package com.spring.boot.security.demo.SpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*tells spring security that this class is a web security configuration*/

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	/* used to configure authentication */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//set config on the auth object
		auth.inMemoryAuthentication()
			.withUser("kani")
			.password("kani")
			.roles("USER")
			.and()
			.withUser("mani")
			.password("mani")
			.roles("ADMIN");
	}
	
	/* used to configure authorization 
	 * antMathers = path pattern 
	 * flow is from most restrictive to least restrictive*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user") .hasAnyRole("USER","ADMIN") 
			.antMatchers("/").permitAll()
			.and().formLogin();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
