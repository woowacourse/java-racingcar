package racingcar.exception;

public class OutOfCarNameLengthException extends RacingCarException {

	private static final String MESSAGE = "자동차의 이름은 5자 이하여야 합니다.";

	public OutOfCarNameLengthException() {
		super(MESSAGE);
	}
}
