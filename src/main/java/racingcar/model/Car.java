package racingcar.model;

import racingcar.util.IntegerConst;

public class Car {
	private final String name;
	private int position;

	public Car(String name) {
		this.name = name;
		this.position = IntegerConst.ZERO.getValue();
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void movePosition(int number) {
		if (number > IntegerConst.MOVE_BOUND.getValue()) {
			++this.position;
		}
	}

	public Boolean isMaxPosition(int maxPosition) {
		return this.position == maxPosition;
	}
}
