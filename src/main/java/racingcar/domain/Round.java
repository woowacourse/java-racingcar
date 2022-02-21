package racingcar.domain;

import java.util.Objects;

public class Round {

	private static final int MINIMUM_VALUE = 1;
	private static final String RANGE_ERROR_MESSAGE = "시도 횟수는 " + MINIMUM_VALUE + " 이상이어야 합니다.";

	private final int number;

	private Round(int number) {
		this.number = number;
	}

	public static Round of(int number) {
		validateValue(number);
		return new Round(number);
	}

	private static void validateValue(int number) {
		if (number < MINIMUM_VALUE) {
			throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Round round = (Round)o;
		return number == round.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
