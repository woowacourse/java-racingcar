package racinggame.domain;

import java.util.Objects;

class Position {

    private static final int ZERO = 0;
    private static final int INCREASE_AMOUNT = 1;
    static final Position DEFAULT_POSITION = new Position(ZERO);

    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int position) {
        checkIsNonNegative(position);

        return new Position(position);
    }

    private static void checkIsNonNegative(int position) {
        if (position < ZERO) {
            throw new IllegalArgumentException(String.format("자동차의 위치는 양수만 가능합니다. 입력한 값: %s", position));
        }
    }

    public Position increase() {
        return Position.from(position + INCREASE_AMOUNT);
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
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
