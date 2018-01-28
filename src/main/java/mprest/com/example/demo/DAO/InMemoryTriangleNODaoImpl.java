package mprest.com.example.demo.DAO;

import mprest.com.common.Shapes.IShape;
import mprest.com.example.demo.Entity.RightTriangle;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* NOT USED

@Component
//@Qualifier("in-memory")
public class InMemoryTriangleNODaoImpl {


    // all
    public Collection<IShape>
    getALLShapes() {
        Collection<IShape> shapes = preCalcshapes.values();
        shapes.addAll(postCalcshapes.values());
        return shapes;
    }

    // count
    public Integer
    getALLShapesCount() {
        return preCalcshapes.size() + postCalcshapes.size();
    }

    // id
    public IShape
    getShapeById(Integer id) {
        IShape shape = preCalcshapes.get(id);
        if (shape==null)
            shape = postCalcshapes.get(id);
        return shape;
    }

    // all by state
    public Collection<IShape>
    getShapesByState(IShape.CalcState state) {
        Collection<IShape> shapes = null;

        if (state == IShape.CalcState.PRE_CALC)
            shapes  = preCalcshapes.values();
        else if (state == IShape.CalcState.POST_CALC)
            shapes  = postCalcshapes.values();
        else
            // throw
            System.out.println("Error: invalid ...");

        return shapes;
    }

    public boolean updateTriangle(int Id, RightTriangle shape) {
        return false;
    }

    public boolean addShape(IShape shape) {
        return false;
    }

    private static Map<Integer, IShape> preCalcshapes = new HashMap<>();
    private static Map<Integer, IShape> postCalcshapes = new HashMap<>();

}
*/