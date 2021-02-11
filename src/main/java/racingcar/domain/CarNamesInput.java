package racingcar.domain;

import racingcar.exception.CarNameDuplicateException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarNamesInput {
    private static final String DELIMITER = ",";

    private final List<String> carNames;

    private CarNamesInput(String input) {
        List<String> unCheckedCarNames = Arrays.asList(input.split(DELIMITER));
        validateCarNameDuplicate(unCheckedCarNames);
        carNames = unCheckedCarNames;
    }

    public static CarNamesInput valueOf(String input) {
        return new CarNamesInput(input);
    }

    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    private void validateCarNameDuplicate(List<String> unCheckedCarNames) {
        if (unCheckedCarNames.stream().distinct().count() != unCheckedCarNames.size()) {
            throw new CarNameDuplicateException();
        }
    }
}
