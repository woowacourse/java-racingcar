package exception;

public class InputCarNameRangeException extends RuntimeException{
    private static final String CAR_NAME_EXCEPTION_MESSAGE = "[ERROR] 자동차 이름의 길이가 1이상 4자 이하여야 합니다.";
    public InputCarNameRangeException() {
        super(CAR_NAME_EXCEPTION_MESSAGE);
    }
}
