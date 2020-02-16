package racingcargame.domain;

public class RepeatTimes {
	private static final int MIN_BOUNDS = 0;

	private int repeatTimes;

	public RepeatTimes(String inputRepeat) {
		int repeatTimes = parseStringToInt(inputRepeat);
		validateNegative(repeatTimes);
		this.repeatTimes = repeatTimes;
	}

	private int parseStringToInt(String inputRepeat) {
		try {
			return Integer.parseInt(inputRepeat);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("정수를 입력해주세요.");
		}
	}

	private void validateNegative(int repeatTimes) {
		if (repeatTimes < MIN_BOUNDS) {
			throw new IllegalArgumentException("반복 횟수는 음수가 될 수 없습니다.");
		}
	}

	public int getRepeatTimes() {
		return repeatTimes;
	}
}
