package racingcar;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {

    public List<Car> parse(String names) {
        return Arrays.stream(names.split(","))
            .map(Car::from)
            .collect(toList());
    }
}
