package racingcar.domain;

public class Car {
	private final Name name;
	private int position = 0;

	public Car(Name name) {
		this.name = name;
	}

	public Car(Name name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name.toString();
	}

	public int getPosition() {
		return position;
	}

	public void moveForward() {
		position++;
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}
}
