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
        lines = new ArrayList<>();
    }

    public Polygon(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public int addLine(Line line) {
        lines.add(line);
        return lines.size();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="LINES",
            joinColumns=@JoinColumn(name="POLYGON_ID")
    )
    private List<Line> lines;
}
