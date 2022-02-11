package racingcar.exception;

public class EmptyCarNameException extends RacingCarException {

	private static final String MESSAGE = "자동차의 이름은 공백이 될 수 없습니다.";

	public EmptyCarNameException() {
		super(MESSAGE);
	}
}
