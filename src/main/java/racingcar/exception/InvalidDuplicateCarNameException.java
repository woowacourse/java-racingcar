package racingcar.exception;

public class InvalidDuplicateCarNameException extends RuntimeException{

    private static final String ERROR_MESSAGE = "[ERROR] 중복된 경주 참가자의 이름이 있습니다.";

    public InvalidDuplicateCarNameException() {
        super(ERROR_MESSAGE);
    }
}
