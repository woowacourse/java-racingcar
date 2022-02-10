package racingcar.model;

import java.util.Objects;

public class TryCount {
	private final int tryCount;

	public TryCount(String countString) {
		this.tryCount = convertStringToInt(countString);
		validatePositive(tryCount);
	}

	private int convertStringToInt(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 시도할 횟수는 숫자여야 합니다.");
		}
	}

	private void validatePositive(int count) {
		if (count <= 0) {
			throw new IllegalArgumentException("[ERROR] 시도할 횟수는 자연수여야 합니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TryCount tryCount1 = (TryCount)o;
		return tryCount == tryCount1.tryCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tryCount);
	}
}
