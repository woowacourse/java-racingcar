package racingcar.model;

import racingcar.validator.NameValidator;

public class Car {

	private static final int MOVE_CRITERIA = 4;
	private final Name name;
	private int position;

	public Car(String name, int position) {
		this.name = new Name(name);
		this.position = position;
	}

	public void decideMove(int number) {
		if (number >= MOVE_CRITERIA) {
			move();
		}
	}

	private void move() {
		position++;
	}

	public Name getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public boolean matchPosition(int position) {
		return this.position == position;
	}

}
