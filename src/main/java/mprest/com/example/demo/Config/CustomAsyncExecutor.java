package mprest.com.example.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class CustomAsyncExecutor extends AsyncConfigurerSupport{
    // Override pool configurations
}
