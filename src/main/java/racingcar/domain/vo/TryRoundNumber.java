package racingcar.domain.vo;

public class TryRoundNumber {

	public static final String INVALID_NOT_NUMBER = "[ERROR] 시행횟수가 숫자가 아닙니다";
	public static final String INVALID_NOT_POSITIVE_NUMBER = "[ERROR] 시행횟수는 0보다 큰 숫자여야 합니다";

	private final int tryRoundNumber;

	public TryRoundNumber(final String input) {
		validateNumber(input);
		this.tryRoundNumber = Integer.parseInt(input);
	}

	public int get() {
		return tryRoundNumber;
	}

	private void validateNumber(final String input) {
		isNumber(input);
		isPositiveNumber(input);
	}

	private void isPositiveNumber(final String input) {
		if (Integer.parseInt(input) <= 0) {
			throw new RuntimeException(INVALID_NOT_POSITIVE_NUMBER);
		}
	}

	private void isNumber(final String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new RuntimeException(INVALID_NOT_NUMBER);
		}
	}
}
