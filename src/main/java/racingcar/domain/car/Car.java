package racingcar.domain.car;

import racingcar.domain.movement.v1.Movement;

public class Car {
	private final CarName name;
	private Position position;

	private Car(final CarName name, final Position position) {
		this.name = name;
		this.position = new Position(position.getValue());
	}

	public static Car from(final String name) {
		return new Car(new CarName(name), Position.INIT);
	}

	// enum 활용
	public void moveV1(final Movement movement) {
		final Position movePosition = new Position(movement.getDistance());
		position = position.move(movePosition);
	}

	// 전략 패턴
	public void moveV2(final int distance) {
		final Position movePosition = new Position(distance);
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
