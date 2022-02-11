package racingCar.model;

import racingCar.utlis.Constants;
import racingCar.utlis.Util;
import racingCar.validator.NameValidator;

public class Car {

	private final String name;
	private int position = 0;

	public Car(String name) throws Exception {
		NameValidator.validateName(name);
		this.name = name;
	}

	public void go() {
		if (Util.getRandomInteger() >= Constants.GO_RANDOM_INTEGER) {
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

	public boolean isWinner(int maxPosition) {
		return position == maxPosition;
	}
}
