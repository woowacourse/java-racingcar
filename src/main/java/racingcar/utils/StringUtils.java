package racingcar.utils;

public class StringUtils {

    private static final String BLANK = " ";
    private static final String NO_BLANK = "";

    private StringUtils() {
    }

    public static String removeAllBlank(String input) {
        return input.replaceAll(BLANK, NO_BLANK);
    }
}
