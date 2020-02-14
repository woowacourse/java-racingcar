package calculator.domain;

public class Delimiter {
    public static final String START_CHARACTER = "//";
    public static final int FIRST_INDEX = 0;
    public static final int START_INDEX = 2;
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String END_CHARACTER = "\n";

    private String delimiter;

    public Delimiter(String input) {
        this.delimiter = DEFAULT_DELIMITER;

        if (hasCustomDelimiter(input)) {
            this.delimiter = defineDelimiter(input);
        }
    }

    protected boolean hasCustomDelimiter(String input) {
        return START_CHARACTER.equals(input.substring(FIRST_INDEX, START_INDEX));
    }

    private String defineDelimiter(String input) {
        return input.substring(START_INDEX, input.indexOf(END_CHARACTER));
    }

    public String getDelimiter() {
        return delimiter;
    }
}