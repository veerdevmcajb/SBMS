package in.veerdev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "in.veerdev")
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig :: Constructor");
	}
	
	
	@Bean
	public AppSecurity getSecurityContextObj() {
		
		AppSecurity security = new AppSecurity("SHA-26");
		return security;
				
	}
}
