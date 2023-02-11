package racingcar.domain;

import racingcar.constant.GameConstant;

import java.util.Objects;

public class Position {
    private int position = GameConstant.RACE_START_POINT;

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position p = (Position) o;
        return Objects.equals(position, p.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
