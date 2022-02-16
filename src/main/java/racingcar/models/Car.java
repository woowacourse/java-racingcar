package racingcar.models;

import racingcar.utils.RandomNumber;

public class Car {

	private static final int FORWARD_STANDARD = 4;
	private static final int INITIAL_POSITION = 0;

	private final String name;
	private int position;

	public Car(final String name) {
		this.name = name;
		position = INITIAL_POSITION;
	}

	public void goForward(int randomNumber) {
		if (randomNumber >= FORWARD_STANDARD) {
			position++;
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public boolean isWinner(final int farthestPosition) {
		return position == farthestPosition;
	}

	@Override
	public String toString() {
		return "Car name= " + name + ", position=" + position;
	}
}
