package racingcar.models;

import racingcar.utils.RandomNumber;

public class Car {

	private static final int FORWARD_STANDARD = 4;
	private static final int INITIAL_POSITION = 0;

	final RandomNumber randomNumber;
	final String name;
	int position;

	public Car(final RandomNumber randomNumber, final String name) {
		this.randomNumber = randomNumber;
		this.name = name;
		position = INITIAL_POSITION;
	}

	public void goForward() {
		if (randomNumber.getRandomNumber() >= FORWARD_STANDARD) {
			position++;
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
