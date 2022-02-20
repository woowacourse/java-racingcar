package racingcar.domain;

public class Car {
	public static final String ERROR_EMPTY_NAME = "[ERROR] 빈 이름이 있습니다.";
	public static final String ERROR_LONG_NAME = "[ERROR] 이름을 5자 이하로 등록해주세요";
	public static final int NAME_LENGTH_LIMIT = 5;

	private final String name;
	private int position = 0;

	public Car(String name) {
		validateName(name);
		this.name = name;
	}

	public Car(String name, int position) {
		validateName(name);
		this.name = name;
		this.position = position;
	}

	private void validateName(String name) {
		checkEmptyName(name);
		checkLongName(name);
	}

	private void checkEmptyName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(ERROR_EMPTY_NAME);
		}
	}

	private void checkLongName(String name) {
		if (name.length() > NAME_LENGTH_LIMIT) {
			throw new IllegalArgumentException(ERROR_LONG_NAME);
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void moveForward() {
		position++;
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}
}
