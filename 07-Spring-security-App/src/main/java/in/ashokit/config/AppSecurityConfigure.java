package in.ashokit.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfigure {
	
	@Bean
	public InMemoryUserDetailsManager inMemoryUsers() {
		UserDetails u1 = User.withDefaultPasswordEncoder()
				.username("ashokit")
				.password("ashokit@123")
				.build();
		
		UserDetails u2 = User.withDefaultPasswordEncoder()
				.username("raju")
				.password("raju@123")
				.build();
		return new InMemoryUserDetailsManager(u1,u2);
	
	}

	// securityFilterchain
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((req) -> 
			req.requestMatchers("/welcome", "/about-us", "/contact-us")
			.permitAll()
			.anyRequest()
			.authenticated()).httpBasic(Customizer.withDefaults())
		.formLogin(Customizer.withDefaults());
		return http.build();

	}
}
