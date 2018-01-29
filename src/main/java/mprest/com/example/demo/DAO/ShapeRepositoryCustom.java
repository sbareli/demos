package mprest.com.example.demo.DAO;

import mprest.com.example.demo.Entity.RightTriangle;

import java.util.List;

public interface ShapeRepositoryCustom {

    void
    refresh(RightTriangle shape);

    List<RightTriangle>
    getTrianglesByState(Integer state);
}

