package racingcargame.model;

public class RaceCount {
	private static int count;

	public RaceCount(int number) {
		initCount(number);
	}

	private static void initCount(int number) {
		count = number;
	}

	static void reduceCount() {
		count--;
	}

	static int getCount() {
		return count;
	}
}
