package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class NameGenerator {
    public static final String DELIMETER = ",";

    public static List<String> generateCarNames(String carNames) {
        NameValidator.isValidateNames(carNames);
        List<String> cars = Arrays.asList(carNames.split(DELIMETER));
        NameValidator.isDuplicatedNames(cars);
        return cars;
    }
}
