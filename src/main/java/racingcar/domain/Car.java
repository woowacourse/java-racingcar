package racingcar.domain;

public class Car {
	private final Name name;
	private final Position position;

	public Car(String name, int position) {
		this.name = new Name(name);
		this.position = new Position(position);
	}

	public Name getName() {
		return name;
	}

	public Position getPosition() {
		return position;
	}

	public void moveForward() {
		position.increase();
	}

	public boolean isSamePosition(Position position) {
		return this.position.equals(position);
	}
}
