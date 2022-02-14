package racingcargame.model;

public class RaceCount {
	private static int count;

	public RaceCount(int number) {
		initCount(number);
	}

	private void initCount(int number) {
		count = number;
	}

	void reduceCount() {
		count--;
	}

	int getCount() {
		return count;
	}
}
