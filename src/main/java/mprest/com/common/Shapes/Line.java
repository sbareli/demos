package mprest.com.common.Shapes;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
final public class Line {


    private Line() {
        length = 0.;
    }

    public Line(Double length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;

        if (other instanceof Line) {
            Line line = (Line)other;
            return (line.length == length);
        }
        return false;
    }

    @Column(name = "Line")
    private Double length;
}
