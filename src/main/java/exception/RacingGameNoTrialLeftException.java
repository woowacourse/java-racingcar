package exception;

public class RacingGameNoTrialLeftException extends RuntimeException {
    public RacingGameNoTrialLeftException(String message) {
        super(message);
    }
}
