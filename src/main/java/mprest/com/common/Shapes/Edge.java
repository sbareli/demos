package mprest.com.common.Shapes;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Getter
@Embeddable
final public class Edge {


    private Edge() {
        length = 0.;
    }

    public Edge(Double length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;

        if (other instanceof Edge) {
            Edge line = (Edge) other;
            return (line.length == length);
        }
        return false;
    }

    @Column(name = "Edge")
    private Double length;
}
