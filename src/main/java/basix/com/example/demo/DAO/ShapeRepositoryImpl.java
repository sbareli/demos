package basix.com.example.demo.DAO;


import basix.com.example.demo.Entity.RightTriangle;
import basix.com.example.demo.Entity.RightTriangle_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

public class ShapeRepositoryImpl implements ShapeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void refresh(RightTriangle shape) {
        entityManager.refresh(shape);
    }

    @Override
    @Transactional
    public void merge(RightTriangle shape) {
        entityManager.merge(shape);
    }

    @Override
    public List<RightTriangle>
    getTrianglesByState(Integer state) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<RightTriangle> criteria = builder.createQuery( RightTriangle.class );

        Root<RightTriangle> RTRoot = criteria.from( RightTriangle.class );
        criteria.select( RTRoot );
        criteria.where( builder.equal( RTRoot.get( RightTriangle_.state ), state ) );

        List<RightTriangle> shapes = entityManager.createQuery( criteria ).getResultList();

        return shapes;
    }
}
