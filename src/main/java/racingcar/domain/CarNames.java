package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarNames {

    private final List<String> names;

    private final String CAR_NAME_DELIMITER = ",";

    public CarNames(String carNames) {
        names = List.copyOf(Arrays.asList(carNames.split(CAR_NAME_DELIMITER)));
    }

    public List<String> getNames() {
        return names;
    }
}
