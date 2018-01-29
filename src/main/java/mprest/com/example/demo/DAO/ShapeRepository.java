package mprest.com.example.demo.DAO;

import mprest.com.example.demo.Entity.RightTriangle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ShapeRepository extends JpaRepository<RightTriangle, Integer>, ShapeRepositoryCustom {

    @Override
    List<RightTriangle> findAll();

    @Override
    long count();

    @Override
    RightTriangle findOne(Integer integer);

    /*
        update or create new.
        wraps entity manager merge or persist.
     */
    @Override
    RightTriangle save(RightTriangle s);

    @Override
    void delete(Integer integer);


}
