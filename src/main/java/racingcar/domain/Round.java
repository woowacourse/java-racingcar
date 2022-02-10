package racingcar.domain;

public class Round {

	private int count;

	public Round(int count) {
		validateCountPositive(count);
		this.count = count;
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
