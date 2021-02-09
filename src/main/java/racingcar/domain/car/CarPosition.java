package racingcar.domain.car;

import java.util.Objects;

public class CarPosition {
    private int position;

    public CarPosition() {
        this.position = 0;
    }

    public CarPosition(int position) {
        this.position = position;
    }

    public CarPosition move() {
        return new CarPosition(position + 1);
    }

    public boolean equalToPosition(int maxPosition) {
        return position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
