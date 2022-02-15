package racingcar.controller;

import java.util.List;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.service.RacingCarService;

public class RacingCarController {

    private RacingCarService service;

    public RacingCarController(String inputCarNames, String inputRoundNumber) {
        this.service = createRacingService(inputCarNames, inputRoundNumber);
    }

    private RacingCarService createRacingService(String inputCarNames, String inputRoundNumber) {
        return new RacingCarService(inputCarNames, inputRoundNumber);
    }

    public boolean isRunnable() {
        return !service.isRoundEnd();
    }

    public Cars run() {
        if (!isRunnable()) {
            return null;
        }
        return service.run(new RandomMovementStrategy());
    }

    public List<Car> end() {
        return service.findWinners();
    }
}
