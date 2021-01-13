package springmvc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/controlador/paginaPrincipal", "/controlador/buscarSueldo", "/controlador/sueldo", "/controlador/lista").permitAll()
			.antMatchers("/controlador/formulario", "/controlador/actualizar", "/controlador/guardarEmpleado").hasAnyRole("ADMIN", "MANAGER")
			.antMatchers("/controlador/eliminar").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
				.formLogin()
					.loginPage("/securityController/loginPage")
					.loginProcessingUrl("/authenticate").defaultSuccessUrl("/controlador/paginaPrincipal", true)
					.permitAll()
			.and()
				.logout()
				.logoutUrl("/logout").logoutSuccessUrl("/securityController/loginPage?logout")
				.permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/securityController/accesDenied");
	}

}