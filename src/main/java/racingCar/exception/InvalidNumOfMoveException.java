package racingCar.exception;

public class InvalidNumOfMoveException extends IllegalArgumentException {

    public InvalidNumOfMoveException(String s) {
        super("[ERROR] " + s);
    }
}
