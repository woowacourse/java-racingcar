package racingCar.exception;

public class NoWinnerException extends RuntimeException {

    public NoWinnerException(String s){
        super("[ERROR] " + s);
    }

}
