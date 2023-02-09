package racingcar.provider;

import racingcar.domain.Cars;

public class TestProvider {
    public static Cars createTestCars() {
        String carNames = "pobi,crong,honux";
        return Cars.of(carNames);
    }
}
