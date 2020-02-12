package racingGame.domain;

public class MovementNumber {
	private static final int ZERO = 0;

	private final int movementNumber;

	public MovementNumber(final String number) {
		final int parsedNumber = checkValidMovementNumber(number);

		checkPositiveMovementNumber(parsedNumber);
		movementNumber = parsedNumber;
	}

	private void checkPositiveMovementNumber(final int parsedNumber) {
		if (parsedNumber < ZERO) {
			throw new IllegalArgumentException("입력한 이동 횟수가 음수입니다.");
		}
	}

	private int checkValidMovementNumber(final String number) {
		return Integer.parseInt(number);
	}
}
