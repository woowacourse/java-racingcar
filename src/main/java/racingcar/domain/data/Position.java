package racingcar.domain.data;

public class Position {
    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public Position move() {
        return new Position(value + 1);
    }

    public boolean isSameAs(int maxPosition) {
        return this.value == maxPosition;
    }

    public boolean isBigger(int maxPosition) {
        return value > maxPosition;
    }
}
