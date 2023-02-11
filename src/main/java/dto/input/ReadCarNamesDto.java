package dto.input;

import java.util.List;

public class ReadCarNamesDto {
    private final List<String> carNames;

    public ReadCarNamesDto(final List<String> carNames) {
        this.carNames = carNames;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
