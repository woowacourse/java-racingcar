package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

    private final String CAR_NAME_DELIMITER = ",";

    private final List<String> names;

    public CarNames(String carNames) {
        List<String> splitNames = Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
        names = splitNames.stream().map(String::trim).collect(Collectors.toUnmodifiableList());
    }

    public List<String> getNames() {
        return names;
    }
}
