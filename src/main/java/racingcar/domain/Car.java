package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car implements Comparable<Car> {
	private static final int MOVING_CAR_BOUND = 4;

	private final String carName;
	private int position;
	private final RandomNumberGenerator randomNumberGenerator;

	public Car(String carName, RandomNumberGenerator randomNumberGenerator) {
		this.carName = carName;
		this.position = 0;
		this.randomNumberGenerator = randomNumberGenerator;
	}

	public void tryMoving() {
		if (isMovable()) {
			position++;
		}
	}

	public boolean isMovable() {
		return randomNumberGenerator.generate() >= MOVING_CAR_BOUND;
	}

	public String getCarName() {
		return this.carName;
	}

	public int getCarPosition() {
		return this.position;
	}

	@Override
	public int compareTo(Car other) {
		return other.position - this.position;
	}
}
