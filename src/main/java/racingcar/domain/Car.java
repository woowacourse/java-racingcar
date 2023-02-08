package racingcar.domain;

public class Car {
	final String name;
	int position;

	public Car(String name) {
		validateNameBlank(name);
		validateNameLength(name);
		this.name = name;
		position = 0;
	}

	private void validateNameBlank(String name) {
		if (name.isBlank()) {
			throw new IllegalArgumentException();
		}
	}

	private void validateNameLength(String name) {
		int nameLength = name.length();
		if (nameLength > 5) {
			throw new IllegalArgumentException();
		}
	}
}
