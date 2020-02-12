package stringcalculator.parser;

public class CustomParsingStrategy extends ParsingStrategy {

    public static final int DELIMITER = 1;
    public static final int NUMBERS = 2;
    private static final String CUSTOM_INPUT_REGEX = "//(.)\n(.*)";

    @Override
    String getRegex() {
        return CUSTOM_INPUT_REGEX;
    }

    @Override
    int getNumbersIndex() {
        return NUMBERS;
    }

    @Override
    String getDelimiter() {
        return super.matcher.group(DELIMITER);
    }
}
