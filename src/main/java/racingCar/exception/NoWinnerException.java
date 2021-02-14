package racingCar.exception;

public class NoWinnerException extends IllegalArgumentException {

    public NoWinnerException(String s) {
        super("[ERROR] " + s);
    }

}
