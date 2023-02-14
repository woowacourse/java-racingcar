package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class Converter {

    private static final String CAR_NAMES_DELIMITER = ",";

    private Converter() {
    }

    public static List<Car> stringToCars(String carNames) {
        String[] split = carNames.split(CAR_NAMES_DELIMITER);
        List<Car> Cars = Arrays.stream(split)
                .map(Car::new)
                .collect(Collectors.toList());
        return Cars;
    }

}
