package racingcargame.exception;

public class CarsNameInputException extends RuntimeException {
    private final CarsNameInputExceptionType type;

    public CarsNameInputException(CarsNameInputExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public CarsNameInputExceptionType getType() {
        return type;
    }
}
