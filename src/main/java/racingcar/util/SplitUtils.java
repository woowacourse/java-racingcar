package racingcar.util;

import static racingcar.constants.OutputMessages.ERROR_NULL;
import static racingcar.constants.SystemConstants.COMMA;

public class SplitUtils {

    public static String[] splitByComma(String string) {
        if (string == null) {
            throw new NullPointerException(ERROR_NULL);
        }
        return string.split(COMMA);
    }
}
