package racingcar.domain;

public class Round {

	private int count;

	public Round(String count) {
		int value = parseCount(count);
		validateCountPositive(value);
		this.count = value;
	}

	private int parseCount(String count) {
		try {
			int value = Integer.parseInt(count);
			return value;
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException("이동 횟수는 숫자여야 합니다.");
		}
	}

	private void validateCountPositive(int count) {
		if (count <= 0) {
			throw new IllegalArgumentException("이동 횟수는 양수여야 합니다.");
		}
	}

	public void decreaseCount() {
		this.count--;
	}

	public boolean isFinish() {
		return this.count == 0;
	}

	public int getCount() {
		return count;
	}
}
