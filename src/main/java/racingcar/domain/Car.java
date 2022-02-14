package racingcar.domain;

import java.util.Random;

import racingcar.domain.validation.CarValidator;
import racingcar.service.StepGenerator;

public class Car implements Comparable<Car> {
	private static final String STEP = "-";
	private static final String FORMAT = "%s : %s";
	private static final int DRIVE_FLAG = 3;

	private final StepGenerator stepGenerator = new StepGenerator();
	private final String name;
	private int position = 0;

	public Car(String name) {
		CarValidator validator = new CarValidator();
		validator.carValid(name);
		this.name = name;
	}

	private void move() {
		position++;
	}

	public void drive() {
		if (hasNext(stepGenerator.generate())) {
			move();
		}
	}

	public boolean hasNext(int random) {
		return random > DRIVE_FLAG;
	}

	public boolean isSamePosition(Car other) {
		return this.position == other.position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		StringBuilder positions = new StringBuilder();
		for (int i = 0; i < position; i++) {
			positions.append(STEP);
		}
		return String.format(FORMAT, name, positions);
	}

	@Override
	public int compareTo(Car car) {
		return this.position - car.position;
	}
}
