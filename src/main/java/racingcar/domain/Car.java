package racingcar.domain;

import racingcar.constants.Constants;

public class Car {

	private String name;
	private int location;

	public Car(String name) {
		this.name = name;
	}

	private void increaseLocation() {
		this.location++;
	}

	public void goForwardOrStop(int pickNumber) {
		if (pickNumber >= Constants.GO_FORWARD_NUMBER) {
			increaseLocation();
		}
	}

	public String toString() {
		return name + Constants.COLON + Constants.PROGRESS_BAR.repeat(location);
	}

	public String getName() {
		return this.name;
	}

	public int getLocation() {
		return this.location;
	}

	public boolean isWinner(int farthestLocation) {
		return location == farthestLocation;
	}
}
