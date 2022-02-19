package racingcar.domain;

import java.util.Objects;

import racingcar.util.Constant;

public class Attempt {
	private final int attempt;

	public Attempt(String attempt) {
		this.attempt = toInt(attempt);
	}

	public boolean isSame(int nowAttempt) {
		return attempt == nowAttempt;
	}

	private int toInt(String number) {
		try {
			int changeInt = Integer.parseInt(number);
			checkNegative(changeInt);
			return changeInt;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(
				String.format("%s 이유 : %s", Constant.ATTEMPT_BLANK_ERROR_MESSAGE, e.getMessage()));
		}
	}

	private void checkNegative(int attempt) {
		if (attempt <= 0) {
			throw new IllegalArgumentException(Constant.ATTEMPT_NEGATIVE_ERROR_MESSAGE);
		}
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
