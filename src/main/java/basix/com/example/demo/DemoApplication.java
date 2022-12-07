package basix.com.example.demo;

import basix.com.example.demo.AsyncServices.AsyncServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.Resource;

@SpringBootApplication
@EnableAsync
@EntityScan(basePackages = {"basix.com.example.demo.Entity", "package basix.com.common.Shapes"})
public class DemoApplication implements CommandLineRunner {

	@Resource
	AsyncServices asyncServices;

	static Logger logger = LoggerFactory.getLogger(DemoApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override public void
	run(String... object) throws Exception {
		logger.info("Starting Async services ...");

		this.asyncServices.processShapes();

		this.asyncServices.countTotalShapes();
	}

}
