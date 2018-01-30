package mprest.com.common.Shapes;

import lombok.Getter;

public interface IShape {

    @Getter
    public enum CalcStates {
        PRE_CALC(0),
        POST_CALC(1);

        private Integer value;
        CalcStates(Integer value) {
            this.value = value;
        }

    }

    void calculate();
}

