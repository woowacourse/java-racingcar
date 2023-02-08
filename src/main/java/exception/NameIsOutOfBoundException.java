package exception;

public class NameIsOutOfBoundException extends RuntimeException {
    public NameIsOutOfBoundException(String message) {
        super(message);
    }
}
