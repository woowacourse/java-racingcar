package racingCar.model;

import racingCar.utlis.Util;

public class Car {
	private static final String ROUND_REGEX = " : ";
	private static final String POSITION_SIGNATURE = "-";

	public final Name name;
	public final Position position = new Position();

	public Car(String name) {
		this.name = new Name(name);
	}

	public void go() {
		final int goNumber = 4;
		if (Util.getRandomInteger() >= goNumber) {
			move();
		}
	}

	public void move() {
		position.move();
	}

	public String getName() {
		return name.toString();
	}

	public String getStateString() {
		return name + ROUND_REGEX + POSITION_SIGNATURE.repeat(position.get()) + System.lineSeparator();
	}
}