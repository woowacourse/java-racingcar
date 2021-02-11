package racingcar.domain.Car.Exception;

public class DriveValueInvalidException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "0과 9사이의 값이어야만 합니다.";

    public DriveValueInvalidException() {
        super(ERROR_MESSAGE);
    }
}
