package basix.com.example.demo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("mprest.com.example.demo")
public class AppConfig {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplateBuilder().build();
	}

}
