package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car implements Comparable<Car> {
	private String carName;
	private int position;
	private RandomNumberGenerator randomNumberGenerator;

	private static final int OPERATING_STANDARD = 4;

	public Car(String carName, RandomNumberGenerator randomNumberGenerator) {
		this.carName = carName;
		this.position = 0;
		this.randomNumberGenerator = randomNumberGenerator;
	}

	public void tryDrive() {
		if (isMovable()) {
			position++;
		}
	}

	public boolean isMovable() {
		if (randomNumberGenerator.generate() >= OPERATING_STANDARD) {
			return true;
		}
		return false;
	}

	public String getCarName() {
		return this.carName;
	}

	@Override
	public int compareTo(Car other) {
		return other.position - this.position;
	}

	@Override
	public String toString() {
		return buildStatusView(new StringBuilder()).toString();
	}

	private StringBuilder buildStatusView(StringBuilder stringBuilder) {
		stringBuilder.append(carName).append(" : ");
		for (int i = 0 ; i < this.position ; i++) {
			stringBuilder.append("-");
		}
		return stringBuilder;
	}
}
