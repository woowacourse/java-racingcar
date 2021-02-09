package racingcar.domain.car;

public class Position {

    public static final Position ZERO = new Position(0);

    private final int value;

    private Position() {
        throw new IllegalStateException("Position 은 위치값을 필요로 합니다.");
    }

    public Position(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치는 0부터 시작합니다.");
        }
        this.value = value;
    }

    public Position move() {
        return new Position(value + 1);
    }

    public boolean is(int position) {
        return value == position;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Position position = (Position) obj;
        return value == position.value;
    }
}
