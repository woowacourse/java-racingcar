package racingCar.domain;

import static racingCar.constants.RacingCarConstants.*;

public class Car {
	private final String name;
	private int position = CAR_INITIAL_POSITION;

	public Car(String name) {
		this.name = name;
	}

	public void moveCar(boolean isGoing) {
		if (isGoing) {
			this.position++;
		}
	}

	public int getPosition() {
		return this.position;
	}

	public boolean isWinner(int maxDistance) {
		return this.position == maxDistance;
	}

	@Override
	public String toString() {
		return name;
	}
}
