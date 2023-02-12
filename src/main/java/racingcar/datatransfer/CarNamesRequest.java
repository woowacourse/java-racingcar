package racingcar.datatransfer;

import java.util.List;

import static racingcar.utils.SplitStringByComma.splitByComma;

public class CarNamesRequest {
    private final List<String> carNames;

    public CarNamesRequest(String carNames) {
        this.carNames = splitByComma(carNames);
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
