package racingCar.exception;

public class InvalidCarNameException extends IllegalArgumentException {

    public InvalidCarNameException(String s) {
        super("[ERROR] " + s);
    }
}
