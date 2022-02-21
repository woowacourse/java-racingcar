package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class NameGenerator {
    private static final String DELIMITER = ",";

    public static List<String> generateCarNames(String carNames) {
        return Arrays.asList(carNames.split(DELIMITER, -1));
    }
}
