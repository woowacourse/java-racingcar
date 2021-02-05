package racingcar.input.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNamesSplitterUtils {
    public static final String CAR_NAMES_DELIMITER = ",";

    public static List<String> splitCarNames(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(CAR_NAMES_DELIMITER))
            .collect(Collectors.toList());
    }
}
