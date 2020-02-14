package racingCar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    public static final String DELIMITER = ",";

    private StringParser() {
    }

    public static List<Name> parseToNameList(String input) throws IllegalArgumentException {
        return Arrays.stream(input.split(DELIMITER))
                .map(Name::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
