package racingcar.domain.car;

public enum NameLength {

	LENGTH(5);

	private final int value;

	NameLength(int value) {
		this.value = value;
	}

	public static boolean isTooLong(String name) {
		return (name.length() > LENGTH.value);
	}

}
