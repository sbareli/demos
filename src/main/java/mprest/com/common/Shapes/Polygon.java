package mprest.com.common.Shapes;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Polygon")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public abstract class Polygon implements IShape {

    public Polygon() {
        edges = new ArrayList<>();
    }

    public Polygon(List<Edge> lines) {
        edges = new ArrayList<>(lines);
    }

    public int addLine(Edge line) {
        edges.add(line);
        return edges.size();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="EDGES",
            joinColumns=@JoinColumn(name="POLYGON_ID")
    )
    private List<Edge> edges;
}
