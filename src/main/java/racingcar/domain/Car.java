package racingcar.domain;

public class Car {
	private static final int MINIMUM_LENGTH_OF_CAR_NAME = 1;
	private static final int MAXIMUM_LENGTH_OF_CAR_NAME = 5;
	private static final int MINIMUM_MOVE_NUMBER = 4;
	private static final int INITIAL_POSITION = 0;

	private final String name;
	private int position;

	public Car(final String name) {
		validateNullName(name);
		validateLengthOfCarName(name);
		this.name = name;
		this.position = INITIAL_POSITION;
	}

	private void validateNullName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("이름이 null일 수 없습니다.");
		}
	}

	private void validateLengthOfCarName(String name) {
		if ((name.length() < MINIMUM_LENGTH_OF_CAR_NAME) || (name.length() > MAXIMUM_LENGTH_OF_CAR_NAME)) {
			throw new IllegalArgumentException(name + "의 길이가 1~5 사이에 있지 않습니다.");
		}
	}

	public boolean move(int randomValue) {
		if (randomValue >= MINIMUM_MOVE_NUMBER) {
			position++;
			return true;
		}
		return false;
	}

	public int compareMaxPosition(int positionToCompare) {
		return Math.max(position, positionToCompare);
	}

	public boolean isMaxPosition(int maxPosition) {
		return position == maxPosition;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(name).append(" : ");
		for (int i = 0; i < position; i++) {
			stringBuilder.append("-");
		}

		return stringBuilder.toString();
	}
}
