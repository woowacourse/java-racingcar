package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Input {
    private static final String DELIMITER = ",";

    private List<String> carNames;

    private Input(String input) {
        carNames = Arrays.asList(input.split(DELIMITER));
    }

    public static Input valueOf(String input) {
        return new Input(input);
    }

    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }
}
