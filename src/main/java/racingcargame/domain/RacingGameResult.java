package racingcargame.domain;

import java.util.List;

public class RacingGameResult {
    private final List<Car> cars;

    public RacingGameResult(Cars cars) {
        this.cars = cars.getDeepCopiedCars();
    }

    public List<Car> getCars() {
        return cars;
    }
}
