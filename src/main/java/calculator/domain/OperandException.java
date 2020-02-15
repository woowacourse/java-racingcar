package calculator.domain;

public class OperandException extends IllegalArgumentException {
	public static final String NOT_NUMBER = "피연산자로는 정수만 올 수 있습니다.";
	public static final String NOT_NEGATVIE = "피연산자로는 음수가 올 수 없습니다.";

	public OperandException(String errMsg) {
		super(errMsg);
	}
}
