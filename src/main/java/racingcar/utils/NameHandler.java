package racingcar.utils;

import racingcar.domain.Name;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameHandler {
    private static final String nameSeparator = ",";

    private NameHandler() {
    }

    public static List<Name> splitNames(final String line) {
        return Arrays.stream(line.split(nameSeparator))
                .map(String::trim)
                .map(name -> Name.create(name))
                .collect(Collectors.toList());
    }
}
