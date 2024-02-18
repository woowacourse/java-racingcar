package racingcar.domain;

public record Position(int position) {

    public Position increasePosition() {
        return new Position(position + 1);
    }
}
