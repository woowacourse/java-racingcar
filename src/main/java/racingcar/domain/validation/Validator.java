package racingcar.domain.validation;

public class Validator {
	private static final String NULL_ERROR = "null";
	private static final String EMPTY_ERROR = "공백";
	private static final String EMPTY = "";

	public void checkBlank(String name, String text) {
		if (name == null) {
			throw new NullPointerException(String.format(text, NULL_ERROR));
		}
		if (name.trim().equals(EMPTY)) {
			throw new IllegalArgumentException(String.format(text, EMPTY_ERROR));
		}
	}
}
