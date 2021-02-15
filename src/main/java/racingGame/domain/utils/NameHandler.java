package racingGame.domain.utils;

import racingGame.domain.racingCar.Name;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameHandler {
    private static final String NAME_SEPARATOR = ",";

    private NameHandler() {
    }

    public static List<Name> splitNames(final String line) {
        return Arrays.stream(line.split(NAME_SEPARATOR))
                .map(String::trim)
                .map(name -> Name.create(name))
                .collect(Collectors.toList());
    }
}
