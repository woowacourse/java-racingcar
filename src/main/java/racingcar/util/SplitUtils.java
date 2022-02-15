package racingcar.util;

import static racingcar.constants.output.ErrorOutputMessages.ERROR_NULL;
import static racingcar.constants.SystemConstants.DELIMITER_COMMA;

public class SplitUtils {

    private SplitUtils() {
        throw new AssertionError();
    }

    public static String[] splitByComma(String string) {
        if (string == null) {
            throw new NullPointerException(ERROR_NULL);
        }
        return string.split(DELIMITER_COMMA);
    }
}
