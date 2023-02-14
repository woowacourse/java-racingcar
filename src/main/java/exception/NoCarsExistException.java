package exception;

public class NoCarsExistException extends RuntimeException {
    
    private final static String MESSAGE = "[ERROR] 자동차가 존재하지 않습니다.";

    public NoCarsExistException() {
        super(MESSAGE);
    }
}
