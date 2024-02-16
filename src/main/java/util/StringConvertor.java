package util;

public class StringConvertor {
    private static final String DELIMITER = ",";

    private StringConvertor() {
    }

    public static String[] splitByDelimiter(String value, String delimiter) {
        return value.split(delimiter);
    }

    public static String getDelimiter() {
        return DELIMITER;
    }
}
