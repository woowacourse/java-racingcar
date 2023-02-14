package dto.input;

import java.util.List;

public class CarNameRequest {
    private final List<String> carNames;

    public CarNameRequest(final List<String> carNames) {
        this.carNames = carNames;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
