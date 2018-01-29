package mprest.com.example.demo.Service;

import mprest.com.example.demo.DAO.ShapeRepository;
import mprest.com.example.demo.Entity.RightTriangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ShapeService {

    @Autowired
    //@Qualifier("in-memory")
    private ShapeRepository shapeDao;

    public List<RightTriangle>
    getAllShapes() {
        return shapeDao.findAll();
    }

    public long
    getAllShapesCount() {
        return shapeDao.count();
    }

    public RightTriangle
    getShapeById(Integer id) {
        return shapeDao.findOne(id);
    }

    // TODO:
    public List<RightTriangle>
    getTrianglesByState(Integer state) {
        return shapeDao.getTrianglesByState(state);
    }

    public RightTriangle
    updateTriangle(Integer id, RightTriangle updatedShape) {
        Optional<RightTriangle> shape = Optional.of(getShapeById(id));

        if (shape.isPresent()) {
            shape.get().setState(updatedShape.getState());

            if (!updatedShape.getLines().isEmpty())
                shape.get().setLines(updatedShape.getLines());
        }

        return shape.get();
    }

    public RightTriangle
    createTriangle(RightTriangle shape) {
        return shapeDao.save(shape);
    }

    public void
    deleteTriangle(Integer id) {
        shapeDao.delete(id);
    }
}
