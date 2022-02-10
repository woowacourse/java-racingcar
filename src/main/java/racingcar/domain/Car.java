package racingcar.domain;

public class Car {

	private String name;
	private int location;

	public Car(String name) {
		this.name = name;
	}

	public void increaseLocation() {
		this.location++;
	}
}
