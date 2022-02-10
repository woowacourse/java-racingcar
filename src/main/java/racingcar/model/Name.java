package racingcar.model;

public class Name {
	private static final int MAX_LENGTH = 5;

	private final String name;

	public Name(String name) {
		this.name = name;
		validate();
	}

	@Override
	public String toString() {
		return this.name;
	}

	private void validate() {
		validateNotEmpty();
		validateBoundary();
	}

	private void validateNotEmpty() {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("[ERROR] 이름은 빈 값으로 입력할 수 없습니다.");
		}
	}

	private void validateBoundary() {
		if (name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 너무 긴 이름입니다.");
		}
	}
}