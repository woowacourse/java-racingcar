package racingcar.utils;

import java.util.Optional;

public class StringUtils {

    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String NO_BLANK = "";

    private StringUtils() {
    }

    public static String[] splitInputName(String values) {
        return Optional.ofNullable(values)
            .filter(StringUtils::checkNull)
            .map(StringUtils::splitByComma)
            .orElseThrow(() -> new IllegalArgumentException("입력값이 없습니다."));
    }

    private static String[] splitByComma(String values) {
        return values.split(COMMA);
    }

    private static boolean checkNull(String values) {
        return values != null;
    }

    public static String removeAllBlank(String input) {
        return input.replaceAll(BLANK, NO_BLANK);
    }
}
