package racingcar.domain;

public class CarMovement {

    private final static String OUT_OF_MOVEMENT_RANGE_EXCEPTION = "범위 밖의 움직임 값입니다.";
    private final int value;

    public CarMovement(int value) {
        this.validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value >= 10 || value < 0) {
            throw new IllegalArgumentException(OUT_OF_MOVEMENT_RANGE_EXCEPTION);
        }
    }

    public boolean isMove() {
        return this.value >= 4;
    }
}
