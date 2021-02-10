package racingCar.domain.car.Engine;

import java.util.Objects;

public class FixedEngine implements Engine {

    private final int num;
    private final int criteria;

    public FixedEngine(int num) {
        this(num, 3);
    }

    public FixedEngine(int num, int criteria) {
        this.num = num;
        this.criteria = criteria;
    }

    @Override
    public boolean isMove() {
        return num > criteria;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FixedEngine that = (FixedEngine) o;
        return num == that.num &&
            criteria == that.criteria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, criteria);
    }
}
