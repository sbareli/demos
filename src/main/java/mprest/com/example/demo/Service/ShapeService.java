package mprest.com.example.demo.Service;

import mprest.com.example.demo.DAO.IShapesRepositoryDao;
import mprest.com.example.demo.Entity.RightTriangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class ShapeService {

    private final IShapesRepositoryDao shapesRepositoryDao;

    @Autowired
    //@Qualifier("in-memory")
    private mprest.com.example.demo.DAO.IShapesRepositoryDao shapeDao;

    public ShapeService(IShapesRepositoryDao shapesRepositoryDao) {
        this.shapesRepositoryDao = shapesRepositoryDao;
    }

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
