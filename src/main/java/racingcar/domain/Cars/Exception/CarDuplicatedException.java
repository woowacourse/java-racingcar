package racingcar.domain.Cars.Exception;

public class CarDuplicatedException extends IllegalArgumentException {
    public static final String ERROR_MESSAGE = "중복 사용자는 허용하지 않습니다.";

    public CarDuplicatedException() {
        super(ERROR_MESSAGE);
    }
}
