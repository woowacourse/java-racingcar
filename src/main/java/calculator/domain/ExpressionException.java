package calculator.domain;

public class ExpressionException extends IllegalArgumentException {
    public static final String NOT_BLANK = "입력값은 공백이 될 수 없습니다.";
    public static final String NOT_NULL = "입력값은 null이 될 수 없습니다.";

    public ExpressionException(String errMsg) {
        super(errMsg);
    }
}
