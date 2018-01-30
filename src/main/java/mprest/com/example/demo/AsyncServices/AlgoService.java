package mprest.com.example.demo.AsyncServices;

import mprest.com.common.Shapes.IShape;
import mprest.com.example.demo.Entity.RightTriangle;
import mprest.com.example.demo.Service.ShapeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class AlgoService {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private ShapeService shapeService ;

    @Async
    public Future<Integer> process() throws InterruptedException {
        logger.info("Start Algo processing with Thread Id:" + Thread.currentThread().getId());

        Integer count;

        Thread.sleep(2000);

        List<RightTriangle> shapes = shapeService.getTrianglesByState(IShape.CalcStates.PRE_CALC.getValue());
        count = shapes.size();

        shapes.forEach( shape-> {
            shape.calculate();
            shapeService.merge(shape);
        });

        return new AsyncResult<>(count);
    }
}
