package racingcar.domain;

import java.util.Objects;

import racingcar.domain.validation.CarValidator;
import racingcar.service.StepPolicy;

public class Car implements Comparable<Car> {
	private static final String STEP = "-";
	private static final String FORMAT = "%s : %s";

	private final String name;
	private int position = 0;

	public Car(String name) {
		CarValidator.carValid(name);
		this.name = name;
	}

	public Car(String name, int position) {
		CarValidator.carValid(name);
		this.name = name;
		this.position = position;
	}

	private void move() {
		position++;
	}

	public void drive(StepPolicy stepPolicy) {
		if (stepPolicy.hasNext()) {
			move();
		}
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

	@Override
	public boolean equals(Object object) {
		if (object instanceof Car) {
			Car car = (Car)object;
			return car.name.equals(name);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
