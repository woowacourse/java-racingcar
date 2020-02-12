package tdd.racingcar.domain;

public class Car {
	private final Position position = new Position(0);
	private final Name name;

	public Car(final String name) {
		this.name = new Name(name);
	}

	public void move(final Power power) {
		if (power.isEnough()) {
			position.move();
		}
	}

	public boolean isPosition(final int maxPosition) {
		return position.isPosition(maxPosition);
	}

	public int getPosition() {
		return position.getPosition();
	}

	public String getName() {
		return name.getName();
	}
}
