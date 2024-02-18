package util;

public class StringConvertor {
    private static final String DELIMITER = ",";

    private StringConvertor() {
    }

    public static String[] splitByDelimiter(final String value, final String delimiter) {
        return value.split(delimiter);
    }

    public static int convertToInt(final String value) {
        return Integer.parseInt(value);
    }

    public static String getDelimiter() {
        return DELIMITER;
    }
}
