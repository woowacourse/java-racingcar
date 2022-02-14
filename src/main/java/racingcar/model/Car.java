package racingcar.model;

import static racingcar.utlis.RandomNumberGenerator.*;

import racingcar.validator.NameValidator;

public class Car {

	static final int MOVE_CRITERIA = 4;
	private final String name;
	private int position;

	public Car(String name, int position) throws Exception {
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

	public boolean isWinner(int maxPosition) {
		return position == maxPosition;
	}

	public boolean isOverMaxPosition(int maxPosition) {
		return position > maxPosition;
	}
}
