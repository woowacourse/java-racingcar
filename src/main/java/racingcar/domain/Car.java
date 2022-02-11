package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car implements Comparable<Car> {
	private static final int OPERATING_STANDARD = 4;
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
		return randomNumberGenerator.generate() >= OPERATING_STANDARD;
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
		for (int i = 0; i < this.position; i++) {
			stringBuilder.append("-");
		}
		return stringBuilder;
	}
}
