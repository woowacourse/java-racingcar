package tdd.racingcar.domain;

import java.util.Objects;

public class TryCount {
	private static final int MIN = 1;

	private int tryCount;

	public TryCount(final String value) {
		checkValidationOf(value);
		tryCount = Integer.parseInt(value);
	}

	private void checkValidationOf(final String value) {
		if (isNotNumber(value)) {
			throw new IllegalArgumentException("횟수는 숫자이어야 합니다.");
		}
		if (isUnderOne(value)) {
			throw new IllegalArgumentException("횟수는 1이상 이어야 합니다.");
		}
	}

	private boolean isNotNumber(final String value) {
		return !value.chars().allMatch(Character::isDigit);
	}

	private boolean isUnderOne(final String value) {
		return Integer.parseInt(value) < MIN;
	}

	public void consume() {
		tryCount--;
	}

	public boolean isRemain() {
		return tryCount >= MIN;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TryCount tryCount1 = (TryCount)o;
		return tryCount == tryCount1.tryCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tryCount);
	}
}
