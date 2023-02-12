package racingcar.domain.car;

public class Car {
	private final CarName name;
	private Position position;

	public Car(final CarName name, final Position position) {
		this.name = name;
		this.position = new Position(position.getValue());
	}

	public void move(final Movement movement) {
		final Position movePosition = new Position(movement.getDistance());
		position = position.move(movePosition);
	}

	public boolean isSamePosition(final Position position) {
		return this.position.isSame(position);
	}

	public String getNameValue() {
		return name.getValue();
	}

	public int getPositionValue() {
		return position.getValue();
	}
}
