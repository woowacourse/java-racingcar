package racingcar.dto;

import java.util.List;

public class CreateRacingCarsDto {

    private final int tryCount;
    private final List<String> carNames;

    public CreateRacingCarsDto(int tryCount, List<String> carNames) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
