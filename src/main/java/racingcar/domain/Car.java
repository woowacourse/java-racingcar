package racingcar.domain;

import static racingcar.exception.ErrorMessages.*;

import java.util.Objects;

import racingcar.utils.RandomNumberGenerator;

public class Car {
	final String name;
	int position;

	public Car(String name) {
		validateNameBlank(name);
		validateNameLength(name);
		this.name = name;
		position = 0;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	private void validateNameBlank(String name) {
		if (name.isBlank()) {
			throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION.getMessage());
		}
	}

	private void validateNameLength(String name) {
		int nameLength = name.length();
		if (nameLength > 5) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION.getMessage());
		}
	}

	public void move() {
		int randomNumber = RandomNumberGenerator.generateRandomNumber();
		if (randomNumber >= 4) {
			position++;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Car)) {
			return false;
		}
		Car car = (Car)o;
		return position == car.position && Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}
