package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class SplitUtil {
    private static final String SPACE = " ";
    private static final String BLANK = "";
    private static final String COMMA = ",";

    public static List<String> splitCarNames(String carNamesInput) {
        return Arrays.asList(carNamesInput.replace(SPACE, BLANK).split(COMMA));
    }
}
