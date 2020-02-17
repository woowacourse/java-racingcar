package calculator.domain;

public class ExpressionException extends IllegalArgumentException {
	public static final String INTEGER_OVERFLOW = "연산의 결과가 정수의 최대값을 초과했습니다.";

	ExpressionException(String errMsg) {
		super(errMsg);
	}
}
