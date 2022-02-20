package racingcar.model;

import java.util.Objects;
import java.util.regex.Pattern;

public class RoundCount {

	private static final String NUMBER_REGEX = "[0-9]+";
	private static final int COUNT_ZERO_CRITERIA = 0;
	private static final String COUNT_NULL_ERROR_MSG = "시도할 횟수가 입력되지 않았습니다.";
	private static final String COUNT_NOT_INTEGER_MSG = "숫자가 아닌 값이 입력되었습니다.";
	private static final String COUNT_ZERO_ERROR_MSG = "0회 이하는 게임을 진행할 수 없습니다.";

	private int roundCount;

	public RoundCount(String roundCount) {
		checkNotNumber(roundCount);
		this.roundCount = convertStringToInteger(roundCount);
		checkCountIsZero(this.roundCount);
	}

	private int convertStringToInteger(String count) {
		return Integer.parseInt(count);
	}

	private void checkNotNumber(String inputString) {
		if (!Pattern.matches(NUMBER_REGEX, inputString)) {
			throw new NumberFormatException(COUNT_NOT_INTEGER_MSG);
		}
	}

	private void checkCountIsZero(int count) {
		if (count == COUNT_ZERO_CRITERIA) {
			throw new IllegalArgumentException(COUNT_ZERO_ERROR_MSG);
		}
	}

	public boolean isOverZero() {
		return roundCount-- > 0;
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
