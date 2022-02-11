package racingcar.exception;

public class InvalidRoundException extends RacingCarException {

	private static final String MESSAGE = "이동 횟수는 양수여야 합니다.";

	public InvalidRoundException() {
		super(MESSAGE);
	}
}
