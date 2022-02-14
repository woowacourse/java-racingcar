package racingcar.model;

import static racingcar.utlis.RandomNumberGenerator.*;

import racingcar.validator.NameValidator;

public class Car {

	static final int MOVE_CRITERIA = 4;
	private final String name;
	private int position;

	public Car(String name, int position) {
		NameValidator.checkCarName(name);
		this.name = name;
		this.position = position;
	}

	public void decideMove() {
		if (isMove()) {
			moveCar();
		}
	}

	private static boolean isMove() {
		return getRandomInt() >= MOVE_CRITERIA;
	}

	private void moveCar() {
		position++;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public boolean matchPosition(int position) {
		return this.position == position;
	}

	public boolean isOverMaxPosition(int maxPosition) {
		return position > maxPosition;
	}
}
