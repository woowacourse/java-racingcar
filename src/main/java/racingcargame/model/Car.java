package racingcargame.model;

import racingcargame.utils.RandomNumberGenerator;

public class Car implements Comparable<Car> {
	private static final int MIN_MOVE_NUMBER = 4;

	private final String name;
	private int position;

	public Car(final String name, final int position) {
		this.name = name;
		this.position = position;
	}

	String getName() {
		return name;
	}

	int getPosition() {
		return position;
	}

	void setPosition(final int position) {
		this.position = position;
	}

	void moveCar() {
		if (isMoveCar()) {
			position++;
		}
	}

	private boolean isMoveCar() {
		int number = RandomNumberGenerator.makeRandomNumber();
		return number >= MIN_MOVE_NUMBER;
	}

	@Override
	public int compareTo(Car car) {
		return Integer.compare(position, car.getPosition());
	}
}
