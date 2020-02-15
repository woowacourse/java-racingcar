package tdd.racingcar.domain;

public class Car {
	private Position position;
	private final Name name;

	public Car(final String name) {
		this.name = new Name(name);
		this.position = new Position(0);
	}

	public void move(final Power power) {
		if (power.isEnough()) {
			position.move();
		}
	}

	public Position getPosition() {
		return position;
	}

	public Name getName() {
		return name;
	}
}
