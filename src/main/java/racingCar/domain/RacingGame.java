package racingCar.domain;

import java.util.List;

public class RacingGame {

    private Cars cars;

    public RacingGame(List<String> carNames) {
        cars = new Cars(carNames);
    }

    public List<String> race() {
        cars.move();
        return cars.getStates();
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }
}
