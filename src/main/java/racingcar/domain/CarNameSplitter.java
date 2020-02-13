package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameSplitter {
    private static final String DELIMETER = ",";

    public static List<Car> split(String input) {
        return Arrays.stream(input.split(DELIMETER))
                .map(String::trim)
                .map(Name::new)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
