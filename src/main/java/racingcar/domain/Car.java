package racingcar.domain;

public class Car {
	private static final int ZERO = 0;
	private static final int CRITERIA = 4;
	private static final int MAXIMUM_NAME = 5;

	private String name;
	private int position;

	public Car(String name) {
		this.name = name;
		position = ZERO;
	}

	public void movePositionAccordingToCondition(int number) {
		if (number >= CRITERIA) {
			move();
		}
	}

	public void move() {
		position++;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public boolean hasOverFiveCharacterName() {
		return name.length() > MAXIMUM_NAME;
	}
}
