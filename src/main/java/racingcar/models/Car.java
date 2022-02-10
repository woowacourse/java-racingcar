package racingcar.models;

import racingcar.RandomNumber;

public class Car {
	final RandomNumber randomNumber;
	final String name;
	int position;

	public Car(final RandomNumber randomNumber, final String name) {
		this.randomNumber = randomNumber;
		this.name = name;
		position = 0;
	}

	public void goForward() {
		if (randomNumber.getRandomNumber() >= 4) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}
}
