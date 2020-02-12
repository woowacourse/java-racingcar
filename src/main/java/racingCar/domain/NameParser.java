package racingCar.domain;

import java.util.Arrays;
import java.util.List;

public class NameParser {
    public static final String DELIMITER = ",";
    public static List<String> parse(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }
}
