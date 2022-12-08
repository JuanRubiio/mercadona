package mercadona.springbootapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import mercadona.springbootapp.repository.UserRepository;
import mercadona.springbootapp.security.JWTAuthorizationFilter;
import mercadona.springbootapp.security.JwtAuthenticationEntryPoint;
import mercadona.springbootapp.utils.Constantes;


@SpringBootApplication
public class SpringbootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootappApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		
		private UserRepository userRepository;
		
		public WebSecurityConfig(UserRepository userRepository) {
			this.userRepository = userRepository;
		}
		
		@Autowired
	    private JwtAuthenticationEntryPoint unauthorizedHandler;
		
		@Autowired
		private Environment env;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			String[] whiteList = env.getProperty(Constantes.AUTH_WHITELIST).split(Constantes.SEPARATOR);
			
			http
				.cors().configurationSource(corsConfigurationSource()).and() 
				.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(this.userRepository, this.env), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(whiteList).permitAll()  // whitelist Swagger UI resources
					.antMatchers("/**").authenticated()  // require authentication for any endpoint that's not whitelisted
					.and()
					.exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
		}
		
		@Bean
		CorsConfigurationSource corsConfigurationSource() {
			//String allowedOrigins = Utilidades.getPropertyFromFileProperties(ConstantesCycred.FILE_PROPERTIES, ConstantesCycred.ALLOWED_ORIGINS);
			String allowedOrigins = env.getProperty(Constantes.ALLOWED_ORIGINS);
			List<String> originsList = new ArrayList<String>(Arrays.asList(allowedOrigins.split(Constantes.SEPARATOR))); 
			
			CorsConfiguration cc = new CorsConfiguration();
			//cc.setAllowedHeaders(Arrays.asList("Origin,Accept", "X-Requested-With", "Content-Type", ConstantesCycred.AUTH_HEADER));
			cc.setAllowedHeaders(Arrays.asList("*"));
			//cc.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://172.23.9.121:30396", "http://cycredsa.z6.web.core.windows.net"));
			cc.setAllowedOrigins(originsList);
			cc.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PUT", "DELETE", "PATCH"));
			cc.setAllowCredentials(true);
			cc.setExposedHeaders(Arrays.asList("*"));
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", cc);
			return source;
		}
	}
}