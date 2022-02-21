package racingCar.domain;

import static racingCar.constants.RacingCarConstants.*;

public class Car {
	private final String name;
	private int position = CAR_INITIAL_POSITION;

	public Car(String name) {
		this.name = name;
	}

	public void moveCar(boolean movable) {
		if (movable) {
			this.position++;
		}
	}

	public int getPosition() {
		return this.position;
	}

	public String getName() {
		return this.name;
	}

	public boolean isWinner(int maxDistance) {
		return this.position == maxDistance;
	}
}
