package racingGame.domain;

public class Name {
	private static final int MAX_NAME_LENGTH = 5;
	private final String name;

	public Name(final String name) {
		checkNameLength(name);
		this.name = name;
	}

	private void checkNameLength(final String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException();
		}
	}
}
