package racingcar.domain;

public enum CarNameLength {

	LENGTH(5);

	private int value;

	CarNameLength(int value) {
		this.value = value;
	}

	public static boolean isTooLong(String name) {
		return (name.length() > LENGTH.value);
	}
}
