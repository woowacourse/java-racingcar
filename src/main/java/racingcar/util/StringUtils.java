package racingcar.util;

public class StringUtils {
    private static final String DISTANCE_MARK = "-";

    public static String convertNumberToString(int cnt) {
        return DISTANCE_MARK.repeat(Math.max(0, cnt));
    }
}
