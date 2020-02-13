package tdd.racingcar.domain;

public class Car {
	private final Name name;
	private final Position position;

	public Car(final String name) {
		this.name = new Name(name);
		this.position = new Position(0);
	}

	public void move(final Power power) {
		if (power.isEnough()) {
			position.move();
		}
	}

	public boolean isPosition(final int position) {
		return this.position.match(position);
	}

	public int getPosition() {
		return position.getValue();
	}

	public String getName() {
		return name.getValue();
	}
}