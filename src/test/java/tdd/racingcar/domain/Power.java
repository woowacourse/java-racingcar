package tdd.racingcar.domain;

public class Power {
	private static final int MIN_POWER = 0;
	private static final int MAX_POWER = 9;

	private final int power;

	public Power(final int power) {
		checkValidationOf(power);
		this.power = power;
	}

	private void checkValidationOf(final int power) {
		if (isInvalid(power)) {
			throw new IllegalArgumentException("파워는 0 이상 9 이하의 값을 가질 수 있습니다.");
		}
	}

	private boolean isInvalid(final int power) {
		return power < MIN_POWER || power > MAX_POWER;
	}
}
