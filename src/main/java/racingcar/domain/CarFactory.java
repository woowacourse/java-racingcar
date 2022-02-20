package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private static final String NAME_REGEX = ",";

    public static List<Car> of(String names) {
        return splitNames(names).stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static List<String> splitNames(String names) {
        return Arrays.stream(names.split(NAME_REGEX))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
