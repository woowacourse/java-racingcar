package racingcar.domain;

import racingcar.exception.CarNameDuplicateException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarNamesInput {
    private static final String DELIMITER = ",";

    private List<String> carNames;

    private CarNamesInput(String input) {
        List<String> carNames = Arrays.asList(input.split(DELIMITER));

        validateCarNameDuplicate(carNames);

        this.carNames = carNames;
    }

    public static CarNamesInput valueOf(String input) {
        return new CarNamesInput(input);
    }

    private void validateCarNameDuplicate(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new CarNameDuplicateException();
        }
    }

    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }
}