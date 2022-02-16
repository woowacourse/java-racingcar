package racingcar.domain;

import racingcar.validator.RacingCarValidator;

public class Count {
	private final static int ZERO = 0;

	private int count;

	public Count(String input) {
		int number = Integer.parseInt(input);
		RacingCarValidator.validateCount(number);
		this.count = number;
	}

	public boolean isPositive() {
		return count > ZERO;
	}

	public void subtract() {
		count--;
	}
}
