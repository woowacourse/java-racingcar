package racingcar.domain;

import java.util.Objects;

import racingcar.domain.validation.AttemptValidator;

public class Attempt {
	private final int attempt;

	public Attempt(String attempt) {
		AttemptValidator.attemptValid(attempt);
		this.attempt = Integer.parseInt(attempt);
	}

	public boolean isSame(int nowAttempt) {
		return attempt == nowAttempt;
	}

	@Override
	public String toString() {
		return "Attempt{" +
			"attempt=" + attempt +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Attempt attempt1 = (Attempt)o;
		return attempt == attempt1.attempt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attempt);
	}
}
