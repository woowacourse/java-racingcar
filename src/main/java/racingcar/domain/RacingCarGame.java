package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingCarGame {
    private final Cars cars;
    private final Lap lap;

    public RacingCarGame(List<String> carNames, Lap lap) {
        this.cars = createRacingCars(carNames);
        this.lap = lap;
    }

    public boolean isEnd() {
        return lap.isZero();
    }

    public void race() {
        cars.raceOneLap();
        lap.decrement();
    }

    public Map<String, Integer> getResult() {
        return cars.getStatus();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }

    private Cars createRacingCars(List<String> carNames) {
        List<Car> value = new ArrayList<>();
        carNames.forEach(carName -> value.add(new Car(new CarName(carName))));
        return new Cars(value);
    }
}
