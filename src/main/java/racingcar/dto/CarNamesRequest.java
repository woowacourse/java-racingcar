package racingcar.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNamesRequest {
    private final List<String> carNames;

    public CarNamesRequest(String carNames) {
        this.carNames = splitByComma(carNames);
    }

    private List<String> splitByComma(String carNames) {
        String[] splitCarNames = carNames.split("\\s*,\\s*");
        return Arrays.stream(splitCarNames).collect(Collectors.toList());
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
