package racingcar;

public class Car {
	private static final int MAX_NAME_LENGTH = 5;
	private static final String NAME_LENGTH_ERROR = "[ERROR] 이름은 5글자를 초과할 수 없습니다.";
	private static final String EMPTY_NAME_ERROR = "[ERROR] 이름은 공백일 수 없습니다.";

	private String name;

	public Car(String name) {
		validateEmptyName(name);
		validateName(name);
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	private void validateEmptyName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_NAME_ERROR);
		}
	}

	private void validateName(String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(NAME_LENGTH_ERROR);
		}
	}
}
