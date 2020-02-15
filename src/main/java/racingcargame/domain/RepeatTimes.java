package racingcargame.domain;

public class RepeatTimes {

	private static final int ZERO = 0;

	private int repeatTimes;

	public RepeatTimes(int repeatTimes) {
		validateNegative(repeatTimes);
		this.repeatTimes = repeatTimes;
	}

	private void validateNegative(int repeat) {
		if (repeat < ZERO) {
			throw new IllegalArgumentException("반복 횟수는 음수가 될 수 없습니다.");
		}
	}

	public int getRepeatTimes() {
		return repeatTimes;
	}
}
