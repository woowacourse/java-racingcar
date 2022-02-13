package racingCar.model;

import racingCar.utlis.Util;
import racingCar.validator.NameValidator;

public class Car {

	private static final String ROUND_REGEX = " : ";
	private static final String POSITION_SIGNATURE = "-";

	private final String name;
	private int position = 0;

	public Car(String name) throws Exception {
		NameValidator.validateName(name);
		this.name = name;
	}

	public void go() {
		final int goNumber = 4;
		if (Util.getRandomInteger() >= goNumber) {
			move();
		}
	}

	public void move() {
		position++;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}

	public String getStateString() {
		return name + ROUND_REGEX + POSITION_SIGNATURE.repeat(position) + System.lineSeparator();
	}
}
