package carracing.model;

import static carracing.model.CarExceptionMessage.*;

import carracing.utils.NumberGenerator;

public class Car {
	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;
	private static final int MOVABLE_NUMBER_THRESHOLD = 4;
	private static final String BLANK_IN_NAME = " ";

	private final String name;
	private int position;

	private Car(String name) {
		validateName(name);

		this.name = name;
		this.position = 0;
	}

	public static Car nameOf(String name) {
		return new Car(name);
	}

	public String getName() {
		return this.name;
	}

	public void move(NumberGenerator numberGenerator) {
		if (numberGenerator.generate() >= MOVABLE_NUMBER_THRESHOLD) {
			this.position++;
		}
	}

	public boolean isAheadOf(Car car) {
		return this.position > car.position;
	}

	public boolean isTiedWith(Car car) {
		return this.position == car.position;
	}

	public int getPosition() {
		return this.position;
	}

	private void validateName(String name) {
		validateLength(name);
		validateBlank(name);
	}

	private void validateLength(String name) {
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION.getMessage());
		}
	}

	private void validateBlank(String name) {
		if (name.contains(BLANK_IN_NAME)) {
			throw new IllegalArgumentException(NAME_BLANK_EXCEPTION.getMessage());
		}
	}
}
