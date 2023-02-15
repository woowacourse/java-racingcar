package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.view.ErrorMessage;

public class Converter {

    private static final String CAR_NAMES_DELIMITER = ",";

    private Converter() {
    }

    public static List<Car> stringToCars(String carNames) {
        String[] split = carNames.split(CAR_NAMES_DELIMITER);
        return Arrays.stream(split)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static int stringToInt(String input) {
        Integer integer = null;
        try {
            integer = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.NOT_NUMBER);
        }
        return integer;
    }

}
