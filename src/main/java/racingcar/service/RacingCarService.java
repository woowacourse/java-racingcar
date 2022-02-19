package racingcar.service;

import java.util.List;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.movement.MovementStrategy;
import racingcar.domain.round.Round;

public class RacingCarService {

    private final Cars cars;
    private final Round round;

    public RacingCarService(String carNames, String roundNumber) {
        this.cars = new Cars(carNames);
        this.round = new Round(roundNumber);
    }

    public boolean isRoundEnd() {
        return round.isEnd();
    }

    public List<Car> run(MovementStrategy strategy) {
        cars.move(strategy);
        round.decrease();
        return cars.getCars();
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }
}
