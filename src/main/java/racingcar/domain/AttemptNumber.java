package racingcar.domain;

import java.util.Objects;

public class AttemptNumber {

	private static final int INIT_VALUE = 0;
	private static final int MINIMUM_VALUE = 1;
	private static final String INTEGER_REGEX = "-?\\d+";

	private static final String TYPE_ERROR_MESSAGE = "시도 횟수는 숫자여야 합니다.";
	private static final String RANGE_ERROR_MESSAGE = "시도 횟수는 1회 이상이어야 합니다.";

	private static final AttemptNumber INIT_ATTEMPT_NUMBER = new AttemptNumber(INIT_VALUE);

	private final int value;

	private AttemptNumber(int value) {
		this.value = value;
	}

	public static AttemptNumber of(String value) {
		validateType(value);
		int parsedValue = Integer.parseInt(value);
		validateRange(parsedValue);

		return new AttemptNumber(parsedValue);
	}

	public static AttemptNumber of(int value) {
		if (value == INIT_VALUE) {
			return INIT_ATTEMPT_NUMBER;
		}

		return new AttemptNumber(value);
	}

	public int value() {
		return value;
	}

	public static void validateType(String value) {
		if (!value.matches(INTEGER_REGEX)) {
			throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
		}
	}

	public static void validateRange(int value) {
		if (value < MINIMUM_VALUE) {
			throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AttemptNumber attempt = (AttemptNumber)o;
		return value == attempt.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
