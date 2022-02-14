package racingcar.model;

class Car {
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final int INITIAL_POSITION = 0;
	private static final int MOVE_CONDITION_NUMBER = 4;
	private static final String ERROR_OVER_CAR_NAME_LENGTH_MESSAGE = "자동차 이름이 5글자를 초과했습니다. 5글자 이하로 입력해주세요.";
	private static final String ERROR_EMPTY_CAR_NAME_MESSAGE = "자동차 이름에 빈 문자열이 입력됐습니다.";

	private final String name;
	private int position;

	Car(String name) {
		validateName(name);
		this.name = name;
		this.position = INITIAL_POSITION;
	}

	void move(int number) {
		if (number >= MOVE_CONDITION_NUMBER) {
			this.position++;
		}
	}

	int getBiggerPosition(int position) {
		return Math.max(position, this.position);
	}

	boolean isSamePosition(int position) {
		return this.position == position;
	}

	CarDto toCarDto() {
		return new CarDto(this.name, this.position);
	}

	private void validateName(String name) {
		validateEmptyName(name);
		validateOverNameLength(name);
	}

	private void validateOverNameLength(String name) {
		if (name.length() > MAX_CAR_NAME_LENGTH) {
			throw new RuntimeException(ERROR_OVER_CAR_NAME_LENGTH_MESSAGE);
		}
	}

	private void validateEmptyName(String name) {
		if (name.isEmpty()) {
			throw new RuntimeException(ERROR_EMPTY_CAR_NAME_MESSAGE);
		}
	}
}
