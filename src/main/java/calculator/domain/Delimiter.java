package calculator.domain;

public class Delimiter {
	private static final String START_CHARACTER = "//";
	private static final String DEFAULT_DELIMITER = ",|:";
	private static final int FIRST_INDEX = 0;
	private static final int END_INDEX = 2;
	private static final int CUSTOM_DELIMITER_INDEX = 3;

	private String delimiter;

	public Delimiter(String input) {
		this.delimiter = DEFAULT_DELIMITER;

		if (hasCustomDelimiter(input)) {
			this.delimiter = defineDelimiter(input);
		}
	}

	public boolean hasCustomDelimiter(String input) {
		return START_CHARACTER.equals(input.substring(FIRST_INDEX, END_INDEX));
	}

	public String defineDelimiter(String input) {
		return input.substring(END_INDEX, CUSTOM_DELIMITER_INDEX);
	}

	public String getDelimiter() {
		return delimiter;
	}
}
