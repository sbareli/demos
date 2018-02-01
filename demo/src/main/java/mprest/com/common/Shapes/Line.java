package mprest.com.common.Shapes;

import lombok.Getter;

@Getter
final public class Line {

    public Line(Double length) {
        _length = length;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;

        if (other instanceof Line) {
            Line line = (Line)other;
            return (line._length == _length);
        }
        return false;
    }

    private Line() {}
    private Double _length;
}
