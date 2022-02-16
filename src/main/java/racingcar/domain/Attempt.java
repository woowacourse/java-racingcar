package racingcar.domain;

import java.util.Objects;

import racingcar.validator.AttemptValidator;

public class Attempt {

	private final int number;

	private Attempt(int number) {
		this.number = number;
	}

	public static Attempt fromStringValue(String number) {
		AttemptValidator.check(number);
		return new Attempt(Integer.parseInt(number));
	}

	public static Attempt fromIntegerValue(int number) {
		return new Attempt(number);
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Attempt attempt = (Attempt)o;
		return number == attempt.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
