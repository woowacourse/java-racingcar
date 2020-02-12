package tdd.racingcar.domain;

import java.util.Objects;

public class TryCount {
	private static final int MIN = 1;

	private int tryCount;

	public TryCount(final int tryCount) {
		checkValidationOf(tryCount);
		this.tryCount = tryCount;
	}

	private void checkValidationOf(final int tryCount) {
		if (tryCount < MIN) {
			throw new IllegalArgumentException("횟수는 1이상 이어야 합니다.");
		}
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
