package racinggame.domain;

import java.util.Objects;

class Position {

    private static final int INCREASE_AMOUNT = 1;

    private final int position;

    public Position(int position) {
        checkIsNonNegative(position);

        this.position = position;
    }

    private void checkIsNonNegative(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("자동차의 위치는 음수가 될 수 없습니다.");
        }
    }

    public Position increase() {
        return new Position(position + INCREASE_AMOUNT);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
