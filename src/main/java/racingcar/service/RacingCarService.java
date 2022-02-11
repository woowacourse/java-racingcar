package racingcar.service;

import java.util.List;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.domain.round.Round;

public class RacingCarService {

    private static final int END_ROUND = 0;

    private final Cars cars;
    private final Round round;

    public RacingCarService(String carNames, String roundNumber) {
        this.cars = new Cars(carNames);
        this.round = new Round(roundNumber);
    }

    public boolean isEnd() {
        return round.isSame(END_ROUND);
    }

    public Cars run() {
        cars.move(new RandomMovementStrategy());
        round.decrease();
        return cars;
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
