package racingCar.model;

import static racingCar.utlis.Util.*;

import racingCar.validator.NameValidator;

public class Car {

	private final String name;
	private int position = 0;

	public Car(String name) throws Exception {
		NameValidator.checkCarName(name);
		this.name = name;
	}

	public void go() {
		if (isMove()) {
			moveCar();
		}
	}

	public void moveCar() {
		position++;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public boolean isWinner(int max) {
		return position == max;
	}
}
