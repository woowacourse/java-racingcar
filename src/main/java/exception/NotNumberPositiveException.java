package exception;

public class NotNumberPositiveException extends IllegalArgumentException {

    public NotNumberPositiveException(String message) {
        super(message);
    }
}
