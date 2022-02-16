package racingcar.models;

import racingcar.utils.RandomNumber;

import java.util.Objects;

public class Car {

	private static final int FORWARD_STANDARD = 4;
	private static final int INITIAL_POSITION = 0;

	private final RandomNumber randomNumber;
	private final String name;
	private int position;

	public Car(final String name) {
		this.randomNumber = RandomNumber.getInstance();
		this.name = name;
		position = INITIAL_POSITION;
	}

	public void goForward() {
		if (randomNumber.getRandomNumber() >= FORWARD_STANDARD) {
			position++;
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return Objects.equals(getName(), car.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName());
	}

	@Override
	public String toString() {
		return name;
	}
}
