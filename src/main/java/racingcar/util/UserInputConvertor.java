package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.CarName;

public class UserInputConvertor {
    private static final String CAR_NAME_DELIMITER = ",";

    public static List<Car> convertToCars(String userInput) {
        return Arrays.stream(userInput.split(CAR_NAME_DELIMITER))
                .map(CarName::new)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
