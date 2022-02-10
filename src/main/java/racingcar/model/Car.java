package racingcar.model;

public class Car {
	private static final int STANDARD_VALUE = 4;

	private Name name;
	private int position;

	public Car(String nameString) {
		this.name = new Name(nameString);
		this.position = 0;
	}

	public void go(int random) {
		if (random >= STANDARD_VALUE) {
			this.position++;
		}
	}

	public String getName() {
		return this.name.getName();
	}

	public int getPosition() {
		return this.position;
	}

	@Override
	public String toString() {
		return name.getName() + " : " + getPositionString();
	}

	private String getPositionString() {
		return "-".repeat(Math.max(0, position));
	}
}
