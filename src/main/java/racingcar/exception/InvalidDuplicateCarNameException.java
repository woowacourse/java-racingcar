package racingcar.exception;

public class InvalidDuplicateCarNameException extends RuntimeException{

    public InvalidDuplicateCarNameException(String message) {
        super(message);
    }
}
