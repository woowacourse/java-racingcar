package racingcar.exception;

public class NotDigitRoundException extends RacingCarException {

	private static final String MESSAGE = "이동 횟수는 숫자여야 합니다.";

	public NotDigitRoundException() {
		super(MESSAGE);
	}
}
