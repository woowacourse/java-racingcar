package exception;

public class CarNameLengthException extends RuntimeException {
    private static final String CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "[ERROR] 자동차 이름의 길이가 1이상 4자 이하여야 합니다.";
    public CarNameLengthException () {
        super(CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
    }
}
