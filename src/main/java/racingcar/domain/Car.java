package racingcar.domain;

import racingcar.utils.Delimiter;

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
		if (pickNumber >= 4) {
			increaseLocation();
		}
	}

	public String toString() {
		return Delimiter.concatWithColon(name, Delimiter.repeatUnderBar(location));
	}

	public String getName() {
		return this.name;
	}

	public int getLocation() {
		return this.location;
	}

}
