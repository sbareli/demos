package mprest.com.example.demo.Components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.opentracing.Span;

@Component
public class ShapeConstraint {

	private final RestTemplate fRestTemplate;
	private final String baseUrl;

	@Autowired
	public ShapeConstraint(RestTemplate restTemplate, @Value("${addressClient.baseUrl}") String baseUrl) {
		this.fRestTemplate = restTemplate;
		this.baseUrl = baseUrl;
	}

	public Boolean verify(Span span) {
		Boolean result = true;

		String url = String.format("%s/shapes/count", baseUrl);
		Long size = fRestTemplate.getForObject(url, Long.class);

		if (size > 1000)
			result = false;

		span.log(String.format("ShapeConstraint verify {%s}", result.toString()));

		return result;
	}
}
