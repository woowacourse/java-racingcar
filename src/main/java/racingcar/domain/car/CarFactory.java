package racingcar.domain.car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static List<Car> from(String names) {
        String[] arrNames = names.split(",");
        return Arrays.stream(arrNames)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
