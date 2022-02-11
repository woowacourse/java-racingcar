package racingcar.model;

import static racingcar.utlis.Util.*;

import racingcar.validator.NameValidator;

public class Car {

	private final String name;
	private int position = 0;

	public Car(String name) throws Exception {
		NameValidator.checkCarName(name);
		this.name = name;
	}

	public void decideMove() {
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

	public boolean isMaxPosition(int max) {
		return position > max;
	}
}
