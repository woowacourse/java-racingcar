package domain;

public class Car {
	private static final int START_POSITION_VALUE = 0;

	private final Name name;
	private int position;

	public Car(String name) {
		this(name, START_POSITION_VALUE);
	}

	public Car(String name, int position) {
		this.name = new Name(name);
		this.position = position;
	}

	public boolean move(RandomNo randomNo) {
		if (randomNo.isMove()) {
			position++;
			return true;
		}
		return false;
	}

	public Name getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}
}
