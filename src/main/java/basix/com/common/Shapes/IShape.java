package basix.com.common.Shapes;

import lombok.Getter;

public interface IShape {

    public enum CalcStates {
        PRE_CALC(0),
        POST_CALC(1);

        @Getter private Integer value;
        CalcStates(Integer value) {
            this.value = value;
        }

    }

    void calculate();
}

