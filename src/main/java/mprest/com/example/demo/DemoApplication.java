package mprest.com.example.demo;

import mprest.com.example.demo.AsyncServices.AlgoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.annotation.Resource;
import java.util.concurrent.Future;

@SpringBootApplication
@EntityScan(basePackages = {"mprest.com.example.demo.Entity", "package mprest.com.common.Shapes"})
public class DemoApplication implements CommandLineRunner {

	@Resource
	AlgoService algoService;

	static Logger logger = LoggerFactory.getLogger(DemoApplication.class.getName());

	public static void main(String[] args) {
		logger.info("Starting main.");
		SpringApplication.run(DemoApplication.class, args);
		logger.info("Ending main");
	}

	@Override public void
	run(String... object) throws Exception {
		logger.info("+++Starting Algo Async service ...");

		while(true) {

			Future<Integer> result = algoService.process();

			while (!result.isDone()) {
				Thread.sleep(1000);
			}

			logger.info("---processed Algo Async service: " + result.get().toString());

		}

	}
}
