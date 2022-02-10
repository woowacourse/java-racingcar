package racingcargame.model;

import java.util.List;

public class RacingCarGame {
    private CarRepository carRepository;

    public RacingCarGame() {
    }

    public void orderToSaveCars(List<String> carNames) {
        carRepository = new CarRepository(carNames);
    }
}
