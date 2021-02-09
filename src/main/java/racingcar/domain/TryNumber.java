package racingcar.domain;

public class TryNumber {

    private final int value;

    public TryNumber(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("[Error] 시도할 횟수는 0보다 커야합니다.\n");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
