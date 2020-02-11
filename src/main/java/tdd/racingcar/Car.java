package tdd.racingcar;

public class Car {
	private static final int MIN_POWER_TO_MOVE = 4;

	private int position = 0;
	private final String name;

	public Car(final String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void move(final int power) {
		if (power >= MIN_POWER_TO_MOVE) {
			position++;
		}
	}

	public String getName() {
		return name;
	}
}
