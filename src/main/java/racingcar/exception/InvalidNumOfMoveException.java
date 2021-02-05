package racingcar.exception;

public class InvalidNumOfMoveException extends RuntimeException {

    public InvalidNumOfMoveException(String s) {
        super("[ERROR] " + s);
    }
}
