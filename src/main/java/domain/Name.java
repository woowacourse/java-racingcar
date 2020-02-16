package domain;

public class Name {
	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;
	private static final String WRONG_NAME_LENGTH_MESSAGE = "이름 길이는 1~5 이여야 합니다.";
	private static final String NOT_INPUT_NAME_MESSAGE = "이름을 입력하지 않았습니다.";

	private final String name;

	public Name(String name) {
		validateNameBlankOrNull(name);
		validateNameLength(name);
		this.name = name.trim();
	}

	private void validateNameBlankOrNull(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException(NOT_INPUT_NAME_MESSAGE);
		}
	}

	private void validateNameLength(String name) {
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(WRONG_NAME_LENGTH_MESSAGE);
		}
	}

	public String getName() {
		return name;
	}

}
