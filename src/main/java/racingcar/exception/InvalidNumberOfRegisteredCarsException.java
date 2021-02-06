package racingcar.exception;

public class InvalidNumberOfRegisteredCarsException extends RuntimeException{

    private static final String ERROR_MESSAGE = "[ERROR] 경주 참가자는 1명 이상 이어야 합니다.";

    public InvalidNumberOfRegisteredCarsException() {
        super(ERROR_MESSAGE);
    }
}
