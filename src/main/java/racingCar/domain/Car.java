package racingCar.domain;

import static racingCar.constants.RacingCarConstants.*;

public class Car {
	String name;
	int position = 0;

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

	public void printName() {
		System.out.print(this.name);
	}

	public boolean isWinner(int maxDistance) {
		return this.position == maxDistance;
	}

	@Override
	public String toString() {
		String output = name + COLON_WITH_SPACE;
		for (int idx = 0; idx < position; idx++) {
			output += DASH;
		}
		return output;
	}
}
