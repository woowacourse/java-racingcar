package racingcar.domain;

import racingcar.util.validator.CarValidator;

public class Car implements Comparable<Car> {

	private static final int INITIAL_POSITION = 0;
	private static final int STANDARD_OF_MOVING = 4;

	private final String name;
	private int position;

	private Car(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public static Car of(String name) {
		CarValidator.checkNameLength(name);

		return new Car(name, INITIAL_POSITION);
	}

	public static Car of(String name, int position) {
		CarValidator.checkNameLength(name);
		CarValidator.checkPositionRange(position);

		return new Car(name, position);
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public Car copy() {
		return Car.of(this.name, this.position);
	}

	public void move(int movingValue) {
		if (movingValue >= STANDARD_OF_MOVING) {
			this.position++;
		}
	}

	public boolean isSamePosition(Car other) {
		return this.position == other.position;
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}

	@Override
	public int compareTo(Car other) {
		return this.position - other.position;
	}
}
