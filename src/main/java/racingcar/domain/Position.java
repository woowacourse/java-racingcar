package racingcar.domain;

public record Position(int value) {
    public static final Position ZERO = new Position(0);

    public Position increasePosition() {
        return new Position(value + 1);
    }
}
