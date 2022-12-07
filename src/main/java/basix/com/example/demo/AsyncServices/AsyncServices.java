package basix.com.example.demo.AsyncServices;

import basix.com.common.Shapes.IShape;
import basix.com.example.demo.Entity.RightTriangle;
import basix.com.example.demo.Service.ShapeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class AsyncServices {
    static Logger logger = LoggerFactory.getLogger(AsyncServices.class);

    @Autowired
    private ShapeService shapeService;

    @Async
    public Future<Integer> processShapes() throws InterruptedException {
        Integer count = 0;

        boolean stop = false;

        while(!stop) {
            Thread.sleep(2000);

            List<RightTriangle> shapes = shapeService.getTrianglesByState(IShape.CalcStates.PRE_CALC.getValue());
            count = shapes.size();

            logger.info("Algo processing with Thread Id:" + Thread.currentThread().getId()
                    + ", processed = " + count.toString());

            shapes.forEach(shape -> {
                shape.calculate();
                shapeService.merge(shape);
            });

            stop = Thread.currentThread().isInterrupted();
        }

        return new AsyncResult<>(count);
    }

    @Async
    public Future<Long> countTotalShapes() throws InterruptedException {
        Long count = 0L;

        boolean stop = false;

        while (!stop) {
            Thread.sleep(5000);

            count = shapeService.getAllShapesCount();

            logger.info("Stat processing with Thread Id:" + Thread.currentThread().getId()
                    + ", Total Shapes Count = " + count.toString());

            stop = Thread.currentThread().isInterrupted();
        }

        return new AsyncResult<>(count);
    }

}
