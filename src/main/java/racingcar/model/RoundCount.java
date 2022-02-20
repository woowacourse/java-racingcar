package racingcar.model;

import java.util.Objects;

public class RoundCount {

	private static final int COUNT_ZERO_CRITERIA = 0;
	private static final int END_COUNT = 0;
	private static final String COUNT_ZERO_ERROR_MSG = "0회 이하는 게임을 진행할 수 없습니다.";

	private int roundCount;

	public RoundCount(int roundCount) {
		checkCountIsZero(roundCount);
		this.roundCount = roundCount;
	}

	private void checkCountIsZero(int count) {
		if (count == COUNT_ZERO_CRITERIA) {
			throw new IllegalArgumentException(COUNT_ZERO_ERROR_MSG);
		}
	}

	public boolean isEnd() {
		return roundCount > END_COUNT;
	}

	public void moveNextRound() {
		roundCount--;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RoundCount that = (RoundCount)o;
		return roundCount == that.roundCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roundCount);
	}

}
