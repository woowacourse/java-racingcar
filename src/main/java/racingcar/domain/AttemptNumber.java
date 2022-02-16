package racingcar.domain;

import java.util.Objects;

import racingcar.validator.AttemptValidator;

public class AttemptNumber {

	private final int value;

	private AttemptNumber(int value) {
		this.value = value;
	}

	public static AttemptNumber fromStringValue(String value) {
		AttemptValidator.check(value);
		return new AttemptNumber(Integer.parseInt(value));
	}

	public static AttemptNumber fromIntegerValue(int value) {
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
