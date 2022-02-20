package racingcar.model;

public class Car {
	private static final int START_POSITION = 0;
	private static final String ERROR_NULL = "[ERROR] 이름에는 null이 사용될 수 없습니다.";
	private static final String ERROR_BLANK = "[ERROR] 이름은 공백일 수 없습니다.";
	private static final String ERROR_LENGTH = "[ERROR] 이름의 길이는 5이상일 수 없습니다.";
	private static final String REGEX_PATTERN = "[^a-zA-Z0-9\\s]";
	private static final String ERROR_SPECIAL_SYMBOL = "[ERROR] 이름에 특수문자가 사용될 수 없습니다.";
	private static final int NAME_LENGTH_CRITERIA = 4;

	private final String name;
	private int position;

	public Car(String name) {
		isValidName(name);
		this.name = name;
		this.position = START_POSITION;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void movePosition(CarMoveStrategy carMoveStrategy) {
		if (carMoveStrategy.satisfy()) {
			this.position++;
		}
	}

	private void isValidName(String name) {
		isNull(name);
		isEmpty(name);
		checkLength(name);
		checkSpecialSymbol(name);
	}

	private void isNull(String name) {
		if (name == null) {
			throw new IllegalArgumentException(ERROR_NULL);
		}
	}

	private void isEmpty(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(ERROR_BLANK);
		}
	}

	private void checkLength(String name) {
		if (name.length() > NAME_LENGTH_CRITERIA) {
			throw new IllegalArgumentException(ERROR_LENGTH);
		}
	}

	private void checkSpecialSymbol(String name) {
		for (int i = 0; i < name.length(); i++) {
			throwSpecialSymbolError(name, i);
		}
	}

	private void throwSpecialSymbolError(String name, int index) {
		if (String.valueOf(name.charAt(index)).matches(REGEX_PATTERN)) {
			throw new IllegalArgumentException(ERROR_SPECIAL_SYMBOL);
		}
	}

}
