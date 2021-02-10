package racingCar.domain.car;

import java.util.Objects;

public class Position {

    public static final Position ZERO = new Position(0);
    private final int position;

    public Position(final int position) {
        if(position < 0){
            throw new IllegalArgumentException("위치는 0부터 시작한다.");
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position goForward() {
        return new Position(position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
