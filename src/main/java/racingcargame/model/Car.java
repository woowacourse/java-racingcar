package racingcargame.model;

import racingcargame.utils.RandomNumberGenerator;

public class Car implements Comparable<Car> {
	private static final int MIN_MOVE_NUMBER = 4;

	private final String name;
	private int position;
	private int moveNumber;

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

	int moveCar() {
		int moveNumber = pickMoveNumber();
		if (moveNumber >= MIN_MOVE_NUMBER) {
			position++;
		}
		return moveNumber;
	}

	private int pickMoveNumber() {
		return RandomNumberGenerator.pickRandomNumber();
	}

	@Override
	public int compareTo(Car car) {
		return Integer.compare(position, car.getPosition());
	}
}
