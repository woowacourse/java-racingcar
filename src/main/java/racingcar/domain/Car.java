package racingcar.domain;

public class Car {

	private final String name;
	private int position;

	private static final int INITIAL_POSITION = 0;
	private static final int STANDARD_OF_MOVING = 4;
	private static final int NAME_LENGTH_LIMIT = 5;

	private static final String EMPTY_CAR_NAME_ERROR_MESSAGE = "자동차의 이름은 1글자 이상이어야 합니다.";
	private static final String INVALID_CAR_NAME_ERROR_MESSAGE = "자동차의 이름은 5글자 이하여야 합니다.";

	private Car(String name, int position) {
		validateCarName(name);
		validatePosition(position);
		this.name = name;
		this.position = position;
	}

	private void validateCarName(String carName) {
		if (carName.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_CAR_NAME_ERROR_MESSAGE);
		}
		if (carName.length() > NAME_LENGTH_LIMIT) {
			throw new IllegalArgumentException(INVALID_CAR_NAME_ERROR_MESSAGE);
		}
	}

	private void validatePosition(int position) {
		if (position < INITIAL_POSITION) {
			throw new IllegalArgumentException();
		}
	}

	public static Car of(String name) {
		return new Car(name, INITIAL_POSITION);
	}

	public static Car of(String name, int position) {
		return new Car(name, position);
	}

	public void move(int movingValue) {
		if (movingValue >= STANDARD_OF_MOVING) {
			position++;
		}
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}

	public CarDto toDto() {
		return new CarDto(this.name, this.position);
	}
}
