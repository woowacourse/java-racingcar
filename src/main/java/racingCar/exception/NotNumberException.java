package racingCar.exception;

public class NotNumberException extends IllegalArgumentException{
	public static final String EXCEPTION_NOT_NUMBER_MESSAGE = "숫자를 입력해주세요.";

	public NotNumberException() {
		super(EXCEPTION_NOT_NUMBER_MESSAGE);
	}
}
