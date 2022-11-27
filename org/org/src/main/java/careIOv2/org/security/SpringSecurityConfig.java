package careIOv2.org.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		//all the request will be authenticated here
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		
		
		//to enable basic auth with default parameters
		http.httpBasic(withDefaults());
		
		http.cors();
		http.csrf().disable();
		
		return http.build();
		
	}
}