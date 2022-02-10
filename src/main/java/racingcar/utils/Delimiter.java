package racingcar.utils;

public enum Delimiter {

	COMMA(","),
	SPACE(" ");

	private final String value;

	Delimiter(String value) {
		this.value = value;
	}

	public static String[] splitWithComma(String targetString) {
		return targetString.split(COMMA.value);
	}

	public static String appendSpaceBehind(String targetString) {
		return targetString + SPACE.value;
	}

}
