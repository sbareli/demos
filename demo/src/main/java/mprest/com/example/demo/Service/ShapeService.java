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

    public boolean
    updateTriangle(Integer id, RightTriangle updatedShape) {
        Optional<RightTriangle> shape = Optional.of(getShapeById(id));

        if (shape.isPresent())
            shapeDao.save(updatedShape);

        return shape.isPresent();
    }

    public RightTriangle
    createTriangle(RightTriangle newShape) {
        return shapeDao.save(newShape);
    }


}
