package mprest.com.example.demo.DAO;

import mprest.com.example.demo.Entity.RightTriangle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface IShapesRepositoryDao extends JpaRepository<RightTriangle, Integer> {
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

}
