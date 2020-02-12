package tdd.racingcar.domain;

import java.util.Iterator;

public class TryCount implements Iterator<Integer> {
	private static final int MIN = 1;

	private int tryCount;

	public TryCount(final int tryCount) {
		validate(tryCount);
		this.tryCount = tryCount;
	}

	private void validate(final int tryCount) {
		if (tryCount < MIN) {
			throw new IllegalArgumentException("횟수는 1이상 이어야 합니다.");
		}
	}

	@Override
	public boolean hasNext() {
		return tryCount >= MIN;
	}

	@Override
	public Integer next() {
		return tryCount--;
	}
}
