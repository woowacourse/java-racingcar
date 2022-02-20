package racingcar.domain;

public class Car {
	private final Name name;
	private int position = 0;

	public Car(String name) {
		this.name = new Name(name);
	}

	public Car(String name, int position) {
		this.name = new Name(name);
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
