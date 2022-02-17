package racingcar.domain;

import racingcar.validator.RacingCarValidator;

public class Count {
	private final static int ZERO = 0;
	private final static String NOT_INT_ERROR = "횟수는 숫자여야 합니다.";

	private int count;

	public Count(String input) {
		try {
			int number = Integer.parseInt(input);
			RacingCarValidator.validateCount(number);

			this.count = number;

		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException(NOT_INT_ERROR);
		}
	}

	public boolean isPositive() {
		return count > ZERO;
	}

	public void subtract() {
		count--;
	}
}
