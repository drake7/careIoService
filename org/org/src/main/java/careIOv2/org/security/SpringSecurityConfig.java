package careIOv2.org.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import careIOv2.org.services.CustomerDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	private final CustomerDetailsService customerDetailsService;
	
	public SpringSecurityConfig(CustomerDetailsService customerDetailsService)
	{
		this.customerDetailsService=customerDetailsService;
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		//all the request will be authenticated here
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()).userDetailsService(customerDetailsService);
		
		
		//to enable basic auth with default parameters
		http.httpBasic(withDefaults());
		
		http.cors();
		http.csrf().disable();
		
		return http.build();
		
	}
	
	@Bean
	PasswordEncoder passwordEncoder()
	{
		
		return NoOpPasswordEncoder.getInstance();
	}
}