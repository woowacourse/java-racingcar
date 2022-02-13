package racingCar.exception;

public class OnlyOneNameException extends IllegalArgumentException{
	private static final String EXCEPTION_ONE_NAME_MESSAGE = "이름을 2개 이상 입력해주세요.";

	public OnlyOneNameException() {
		super(EXCEPTION_ONE_NAME_MESSAGE);
	}
}
