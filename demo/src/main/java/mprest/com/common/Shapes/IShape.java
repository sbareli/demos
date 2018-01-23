package mprest.com.common.Shapes;

public interface IShape {
    enum CalcState {PRE_CALC, POST_CALC};
    void calculate();
}

