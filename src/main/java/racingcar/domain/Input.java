package racingcar.domain;

import racingcar.exception.CarNameDuplicateException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Input {
    private static final String DELIMITER = ",";

    private List<String> carNames;

    private Input(String input) {
        carNames = Arrays.asList(input.split(DELIMITER));
        validateCarNameDuplicate();
    }

    public static Input valueOf(String input) {
        return new Input(input);
    }

    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    private void validateCarNameDuplicate() {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new CarNameDuplicateException();
        }
    }
}
