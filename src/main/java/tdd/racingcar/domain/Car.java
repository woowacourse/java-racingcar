package tdd.racingcar.domain;

public class Car {
	private Position position = new Position(0);
	private final Name name;

	public Car(final String name) {
		this.name = new Name(name);
	}

	public int getPosition() {
		return position.getPosition();
	}

	public void move(final Power power) {
		if (power.isEnough()) {
			position.move();
		}
	}

	public String getName() {
		return name.getName();
	}

	public boolean isPosition(final int maxPosition) {
		return position.equals(new Position(maxPosition));
	}
}
