package tdd.racingcar;

public class Car {
	private static final int MIN_POWER_TO_MOVE = 4;
	private static final int MAX_NAME_LENGTH = 5;

	private int position = 0;
	private final String name;

	public Car(final String name) {
		checkValidation(name);
		this.name = name;
	}

	private void checkValidation(final String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("이름은 최대 5자까지 가능합니다.");
		}
	}

	public int getPosition() {
		return position;
	}

	public void move(final int power) {
		if (power >= MIN_POWER_TO_MOVE) {
			position++;
		}
	}

	public String getName() {
		return name;
	}
}
