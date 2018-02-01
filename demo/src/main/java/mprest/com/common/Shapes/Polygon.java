package mprest.com.common.Shapes;

import java.util.ArrayList;
import java.util.List;


public abstract class Polygon implements IShape {

    public Polygon() {
        _lines = new ArrayList<>();
    }

    public Polygon(List<Line> lines) {
        _lines = new ArrayList<>(lines);
    }

    public int addLine(Line line) {
        _lines.add(line);
        return _lines.size();
    }

    public List<Line> getLines() {
        return new ArrayList<>(_lines);
    }

    private List<Line> _lines;
}
