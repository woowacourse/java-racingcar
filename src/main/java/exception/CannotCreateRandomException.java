package exception;

public class CannotCreateRandomException extends RuntimeExceptionImpl {

    private static final String CANNOT_CREATE_RANDOM = "랜덤 객체를 생성할 수 없습니다.";

    public CannotCreateRandomException() {
        super(CANNOT_CREATE_RANDOM);
    }
}

