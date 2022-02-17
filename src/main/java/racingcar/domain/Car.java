package racingcar.domain;

import racingcar.validator.CarNameValidator;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		CarNameValidator.validateName(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void moveForward() {
		position++;
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}
}
