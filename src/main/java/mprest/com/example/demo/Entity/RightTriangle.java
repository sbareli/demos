package mprest.com.example.demo.Entity;

import lombok.Setter;
import lombok.Getter;
import mprest.com.common.Shapes.Edge;
import java.util.List;
import mprest.com.common.Shapes.Polygon;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
@Table(name = "RightTriangle")
public class RightTriangle extends Polygon {

    public RightTriangle() {
        state = CalcStates.PRE_CALC.getValue();
    }

    @Override
    public void calculate() {
        List<Edge> lines = getEdges();

        if (lines.size() == 2) {
            Double line1 = lines.get(0).getLength();
            Double line2 = lines.get(1).getLength();
            double hypotenuse = Math.sqrt(line1*line1 + line2*line2);
            addLine(new Edge(hypotenuse));
            state = CalcStates.POST_CALC.getValue();
        }

    }

    @NotNull
    @Column(nullable = false)
    private Integer state;
}
