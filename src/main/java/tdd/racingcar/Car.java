package tdd.racingcar;

public class Car {
	private static final int MIN_POWER_TO_MOVE = 4;

	private int position = 0;

	public int getPosition() {
		return position;
	}

	public void move(final int power) {
		if (power >= MIN_POWER_TO_MOVE) {
			position++;
		}
	}
}
