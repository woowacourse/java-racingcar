package stringcalculator.parser;

public class DefaultParsingStrategy extends ParsingStrategy {
    public static final String DEFAULT_REGEX = "(.*)";
    public static final int NUMBERS = 1;
    private static final String DEFAULT_DELIMITER = "[,:]";

    @Override
    String getRegex() {
        return DEFAULT_REGEX;
    }

    @Override
    int getNumbersIndex() {
        return NUMBERS;
    }

    @Override
    String getDelimiter() {
        return DEFAULT_DELIMITER;
    }
}
