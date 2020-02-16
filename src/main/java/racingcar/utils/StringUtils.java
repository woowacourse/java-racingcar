package racingcar.utils;

public class StringUtils {

    public static final String DELIMITER = ",";
    public static final String BLANK = " ";
    public static final String REPLACEMENT = "";

    private StringUtils() {
    }

    public static String[] splitInputName(String values) {
        return values.split(DELIMITER);
    }

    public static String removeAllBlank(String value) {
        return value.replaceAll(BLANK, REPLACEMENT);
    }
}
