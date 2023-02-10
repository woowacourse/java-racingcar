package racingcar.domain;

import static racingcar.exception.ErrorMessages.*;

import java.util.Objects;

public class Car {
	private static final int CAR_NAME_MAX_LENGTH = 5;

	private final String name;
	private final CarMovement carMovement;
	private int position;

	public Car(String name) {
		this(name, new CarMovement(new RandomNumberGenerator()));
	}

	public Car(String name, CarMovement carMovement) {
		validateNameNullOrBlank(name);
		validateNameLength(name);
		this.name = name;
		this.position = 0;
		this.carMovement = carMovement;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	private void validateNameNullOrBlank(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION.getMessage());
		}
	}

	private void validateNameLength(String name) {
		int nameLength = name.length();
		if (nameLength > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION.getMessage());
		}
	}

	public void move() {
		if (carMovement.isCarMoveForward()) {
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
