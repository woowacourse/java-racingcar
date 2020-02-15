package racingcar.domain;

public class Car implements Comparable<Car> {
	private static final int ZERO = 0;
	private static final int CRITERIA = 4;
	private static final int MAXIMUM_NAME_LENGTH = 5;

	private final String name;
	private int position;

	public Car(String name) {
		validateNameLength(name);
		this.name = name;
		position = ZERO;
	}

	public void movePositionAccordingToCondition(int number) {
		if (number >= CRITERIA) {
			move();
		}
	}

	private void validateNameLength(String name) {
		if (name.length() > MAXIMUM_NAME_LENGTH) {
			throw new IllegalArgumentException("이름은 " + MAXIMUM_NAME_LENGTH + "자 이하여야 합니다.");
		}
	}

	public void move() {
		position++;
	}

	public boolean isMaxPosition(Car other) {
		return other.position == this.position;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Car other) {
		return this.position - other.position;
	}
}
