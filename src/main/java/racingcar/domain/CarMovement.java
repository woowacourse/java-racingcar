package racingcar.domain;

public class CarMovement {

    private final static String OUT_OF_MOVEMENT_RANGE_EXCEPTION = "범위 밖의 움직임 값입니다.";
    private final static int MAX_VALUE = 9;
    public final static int MIN_VALUE = 0;
    private final int value;

    public CarMovement(int value) {
        this.validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value > MAX_VALUE || value < MIN_VALUE) {
            throw new IllegalArgumentException(OUT_OF_MOVEMENT_RANGE_EXCEPTION);
        }
    }

    public boolean isMove() {
        return this.value >= 4;
    }
}
