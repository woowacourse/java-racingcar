package racingcar.utils;

import racingcar.domain.Name;

import java.util.Arrays;

public class NameHandler {
    private static final String nameSeparator = ",";

    public static Name[] splitNames(final String line) {
        return Arrays.stream(line.split(nameSeparator))
                .map(String::trim)
                .map(name -> Name.create(name))
                .toArray(Name[]::new);
    }
}
