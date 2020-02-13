package racing.domain;

import java.util.concurrent.ThreadLocalRandom;

public class Car {
	private static final int FORWARD_PIVOT = 4;
	private static final int RANDOM_MAX = 9;
	private static final int RANDOM_MIN = 0;
	private String name;
	private int position;

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public int randomGenerate() {
		return ThreadLocalRandom.current()
			.ints(RANDOM_MIN, RANDOM_MAX)
			.findFirst()
			.orElse(RANDOM_MIN);
	}

	public void goForward(int number) {
		if (number >= FORWARD_PIVOT) {
			position++;
		}
	}

	public boolean isWinner(int winnersPosition) {
		return this.position == winnersPosition;
	}
}
