package calculator.domain;

public class Delimiter {
    public static final String START_CHARACTER = "//";
    public static final int FIRST_INDEX = 0;
    public static final int START_INDEX = 2;
    public static final String DEFAULT_DELIMITER = ",|:";

    private String delimiter;

    public Delimiter(String input) {
        this.delimiter = DEFAULT_DELIMITER;

        if (hasCustomDelimiter(input)) {
            this.delimiter = defineDelimiter(input);
        }
    }

    public boolean hasCustomDelimiter(String input) {
        return START_CHARACTER.equals(input.substring(FIRST_INDEX, 2));
    }

    public String defineDelimiter(String input) {
        return input.substring(START_INDEX);
    }

    public String getDelimiter() {
        return delimiter;
    }
}
