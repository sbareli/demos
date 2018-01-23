package mprest.com.example.demo.Entity;

import mprest.com.common.Shapes.Line;

import java.util.List;
import lombok.Getter;
import mprest.com.common.Shapes.Polygon;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Entity
@Table(name = "RightTriangle")
public class RightTriangle extends Polygon {
    final static Integer PRE_CALC = 0;
    final static Integer POST_CALC = 1;

    public RightTriangle() {
        state = PRE_CALC;
    }

    @Override
    public void calculate() {
        List<Line> lines = getLines();

        if (lines.size() == 2) {
            Double line1 = lines.get(0).get_length();
            Double line2 = lines.get(1).get_length();
            double hypotenuse = Math.sqrt(line1*line1 + line2*line2);
            addLine(new Line(hypotenuse));
            state = POST_CALC;
        }

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Integer state;
}
