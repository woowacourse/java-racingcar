package racingcar.domain;

import java.util.Objects;

import racingcar.validator.AttemptValidator;

public class AttemptNumber {

	private static final int INIT_VALUE_OF_ATTEMPT_NUMBER = 0;
	private static final AttemptNumber INIT_ATTEMPT_NUMBER = new AttemptNumber(INIT_VALUE_OF_ATTEMPT_NUMBER);

	private final int value;

	private AttemptNumber(int value) {
		this.value = value;
	}

	public static AttemptNumber of(String value) {
		AttemptValidator.check(value);
		return new AttemptNumber(Integer.parseInt(value));
	}

	public static AttemptNumber of(int value) {
		if (value == INIT_VALUE_OF_ATTEMPT_NUMBER) {
			return INIT_ATTEMPT_NUMBER;
		}
		return new AttemptNumber(value);
	}

	public int value() {
		return value;
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
