package basix.com.common.Shapes;

import lombok.Getter;

@Getter
final public class Point {

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;

        if (other instanceof Point) {
            Point point = (Point)other;
            return (_x == point._x) && (_y == point._y);
        }
        return false;
    }

    public Point(int x, int y) {
        _x = x;
        _y = y;
    }


    private Point() {};
    private int _x;
    private int _y;
}
