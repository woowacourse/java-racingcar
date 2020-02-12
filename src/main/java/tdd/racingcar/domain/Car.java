package tdd.racingcar.domain;

public class Car {
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

	public void move(final Power power) {
		if (power.isEnough()) {
			position++;
		}
	}

	public String getName() {
		return name;
	}

	public boolean isPosition(final int maxPosition) {
		return position == maxPosition;
	}
}
