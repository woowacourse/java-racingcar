package racingcar.domain;

import java.util.Objects;

import racingcar.validator.AttemptValidator;

public class Attempt {

	private final int number;

	public Attempt(String number) {
		AttemptValidator.check(number);
		this.number = Integer.parseInt(number);
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
