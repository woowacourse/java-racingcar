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

	void moveCar() {
		if (canMoveCar()) {
			position++;
		}
	}

	private boolean canMoveCar() {
		int number = RandomNumberGenerator.makeRandomNumber();
		return number >= MIN_MOVE_NUMBER;
	}

	@Override
	public int compareTo(Car car) {
		return Integer.compare(position, car.getPosition());
	}
}
