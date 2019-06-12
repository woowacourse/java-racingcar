package exception;

public class CarNameLenExceedException extends RuntimeException {
    public CarNameLenExceedException(String message) {
        super(message);
    }
}
