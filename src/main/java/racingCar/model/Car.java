package racingCar.model;

import racingCar.utlis.Util;
import racingCar.validator.NameValidator;

public class Car {

	private String name;
	private int position = 0;

	public Car(String name) throws Exception {
		NameValidator.checkSpace(name);
		NameValidator.checkNameSize(name);
		NameValidator.checkSpecialChar(name);
		this.name = name;
	}

	public void go() {
		if (Util.getRandomInt() >= 4) {
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
