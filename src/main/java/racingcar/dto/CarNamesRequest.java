package racingcar.dto;

import java.util.List;

public class CarNamesRequest {
    private final List<String> carNames;

    public CarNamesRequest(List<String> inputCarNames) {
        this.carNames = inputCarNames;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
