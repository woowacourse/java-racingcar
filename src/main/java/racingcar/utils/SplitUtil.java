package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class SplitUtil {

    public static List<String> splitCarNames(String carNamesInput) {
        return Arrays.asList(carNamesInput.replace(" ", "").split(","));
    }
}
