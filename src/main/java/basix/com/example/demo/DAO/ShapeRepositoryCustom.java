package basix.com.example.demo.DAO;

import basix.com.example.demo.Entity.RightTriangle;

import java.util.List;

public interface ShapeRepositoryCustom {

    void
    refresh(RightTriangle shape);

    void
    merge(RightTriangle shape);

    List<RightTriangle>
    getTrianglesByState(Integer state);
}

