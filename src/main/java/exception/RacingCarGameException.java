package exception;

public class RacingCarGameException extends IllegalArgumentException{
    private RacingCarGameException(ErrorMessage message) {
        super(message.getMessage());
    }

    public static RacingCarGameException from(ErrorMessage message) {
        return new RacingCarGameException(message);
    }
}
