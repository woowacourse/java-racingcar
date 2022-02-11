package racingcar.domain;

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
		return name + " : " + "-".repeat(location);
	}

	public String getName() {
		return this.name;
	}

	public int getLocation() {
		return this.location;
	}
}
