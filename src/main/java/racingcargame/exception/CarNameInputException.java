package racingcargame.exception;

public class CarNameInputException extends RuntimeException {
    private final CarNameInputExceptionType type;

    public CarNameInputException(CarNameInputExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public CarNameInputExceptionType getType() {
        return type;
    }
}
