package racingcar.model;

public class Car {
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final int INITIAL_POSITION = 0;
	private static final int MOVE_CONDITION_NO = 4;
	private static final String CAR_NAME_LENGTH_OVER_ERROR_MESSAGE = "자동차 이름이 5글자를 초과했습니다. 5글자 이하로 입력해주세요.";
	private static final String CAR_NAME_IS_EMPTY_ERROR_MESSAGE = "자동차 이름에 빈 문자열이 입력됐습니다.";
	private final String name;
	private int position;

	public Car(String name) {
		validName(name);
		this.name = name;
		this.position = INITIAL_POSITION;
	}

	private void validName(String name) {
		if (isOverNameLength(name)) {
			throw new RuntimeException(CAR_NAME_LENGTH_OVER_ERROR_MESSAGE);
		}
		if (isEmptyName(name)) {
			throw new RuntimeException(CAR_NAME_IS_EMPTY_ERROR_MESSAGE);
		}
	}

	private boolean isOverNameLength(String name) {
		return name.length() > MAX_CAR_NAME_LENGTH;
	}

	private boolean isEmptyName(String name) {
		return name.isEmpty();
	}

	public void move(int number) {
		if (number >= MOVE_CONDITION_NO) {
			this.position++;
		}
	}

	public int getBiggerPosition(int maxPosition) {
		return Math.max(maxPosition, this.position);
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}

	public CarDto toCarDto() {
		return new CarDto(this.name, this.position);
	}
}
