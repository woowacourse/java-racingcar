package racingcar.domain;

public record Position(int value) {

    public Position increasePosition() {
        return new Position(value + 1);
    }
}
