package mprest.com.example.demo.Controller;

import mprest.com.example.demo.Entity.RightTriangle;
import mprest.com.example.demo.Service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shapes")
public class ShapeController {

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

    @RequestMapping(value = "/{id}", method=RequestMethod.PUT, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public RightTriangle updateTriangle(@PathVariable("id") int id, @RequestBody RightTriangle shape)
    {
        return shapeService.updateTriangle(id, shape);
    }

    @RequestMapping(value = "/rightTriangles", method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public RightTriangle createTriangle(@RequestBody RightTriangle shape) {
        return shapeService.createTriangle(shape);
    }

    @DeleteMapping("/{id}")
    public void deleteTriangle(@PathVariable("id") int id) {
        shapeService.deleteTriangle(id);
    }
}
