package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class NameGenerator {
    public static final String DELIMITER = ",";

    public static List<String> generateCarNames(String carName) {
        NameValidator.isValidateNames(carName);
        List<String> carNames = Arrays.asList(carName.split(DELIMITER));
        NameValidator.isDuplicatedNames(carNames);
        return carNames;
    }
}
