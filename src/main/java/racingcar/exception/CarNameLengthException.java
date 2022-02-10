package racingcar.exception;

public class CarNameLengthException extends IllegalArgumentException {

    public CarNameLengthException(String s) {
        super(s);
    }
}
