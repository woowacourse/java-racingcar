package racingCar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameParser {
    public static final String DELIMITER = ",";

    public static List<PlayerName> parse(String input) throws IllegalArgumentException {
        return Arrays.stream(input.split(DELIMITER))
                .map(PlayerName::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
