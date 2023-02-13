package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {
    private static final String CAR_NAME_DELIMITER = ",";
    public static List<String> parsing(String text) {
        return Arrays.asList(text.split(CAR_NAME_DELIMITER));
    }
}