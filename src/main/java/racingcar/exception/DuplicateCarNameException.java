package racingcar.exception;

public class DuplicateCarNameException extends RacingCarException {

	private static final String MESSAGE = "자동차의 이름은 중복될 수 없습니다.";

	public DuplicateCarNameException() {
		super(MESSAGE);
	}
}
