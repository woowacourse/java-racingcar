package racingcar.domain;

public class Car {
	static final int INITIAL_POSITION = 0;
	private static final int MINIMUM_LENGTH_OF_CAR_NAME = 1;
	private static final int MAXIMUM_LENGTH_OF_CAR_NAME = 5;
	private static final int MINIMUM_MOVE_NUMBER = 4;

	private final String name;
	private int position;

	public Car(String name) {
		validateLengthOfCarName(name);
		this.name = name;
		this.position = INITIAL_POSITION;
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

	public int getBiggerPosition(int positionToCompare) {
		return Math.max(position, positionToCompare);
	}

	public boolean isMaxPosition(int maxPosition) {
		return position == maxPosition;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
