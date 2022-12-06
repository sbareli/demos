package mprest.com.example.demo.Controller;

import io.opentracing.Tracer;
import mprest.com.example.demo.Entity.RightTriangle;
import mprest.com.example.demo.Service.ShapeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shapes")
public class ShapeController {

	private static final Logger log = LoggerFactory.getLogger(ShapeController.class);

	@Autowired
	private Tracer fTracer;

    @Autowired
    private ShapeService shapeService ;

    @GetMapping("/all")
    public List<RightTriangle>
    getAllShapes() {
        return shapeService.getAllShapes();
    }

    @GetMapping("/count")
    public Long
    getAllShapesCount() {
        return shapeService.getAllShapesCount();
    }

    @GetMapping("/{id}")
    public RightTriangle getShapeById(@PathVariable("id") int id) {
        return shapeService.getShapeById(id);
    }

    @GetMapping("/state/{state}")
    public List<RightTriangle> getShapesByState(@PathVariable("state") int state) {
        return shapeService.getTrianglesByState(state);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RightTriangle updateTriangle(@PathVariable("id") int id, @RequestBody RightTriangle shape) {
        return shapeService.updateTriangle(id, shape);
    }

    @RequestMapping(value = "/rightTriangles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RightTriangle createTriangle(@RequestBody RightTriangle shape, @RequestHeader Map<String,String> headers) {

    	log.info("Inside /rightTriangles");
    	log.info("Span: " + fTracer.activeSpan().context().toSpanId());

    	headers.forEach( (k,v) -> {
    		log.info("Header '{}' = {}", k, v);
	    });

        return shapeService.createTriangle(shape);
    }

    @DeleteMapping("/{id}")
    public void deleteTriangle(@PathVariable("id") int id) {
        shapeService.deleteTriangle(id);
    }
}
