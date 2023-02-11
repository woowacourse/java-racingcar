package exception;

public class CannotFindMaxPositionException extends RuntimeExceptionImpl {

    private static final String CANNOT_FIND_MAX_POSITION = "최대 거리를 찾을 수 없습니다.";

    public CannotFindMaxPositionException() {
        super(CANNOT_FIND_MAX_POSITION);
    }
}
