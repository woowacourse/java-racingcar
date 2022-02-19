package racingcar.domain.game;

import racingcar.domain.car.Cars;
import racingcar.domain.movement.Movement;
import racingcar.domain.trialcount.TrialCount;
import racingcar.dto.CarDto;

import java.util.List;

public class Game {
    private final Cars cars;
    private final TrialCount trialCount;
    private final Movement movementStrategy;

    public Game(final List<String> carNames, final int trialCount, final Movement movementStrategy) {
        this.cars = new Cars(carNames);
        this.trialCount = new TrialCount(trialCount);
        this.movementStrategy = movementStrategy;
    }

    public void playOneRound() {
        cars.move(movementStrategy);
        trialCount.decrease();
    }

    public boolean isNotOver() {
        return trialCount.isHigherThanZero();
    }

    public List<CarDto> getRoundResult() {
        return cars.getCarInfos();
    }

    public List<CarDto> getWinners() {
        return cars.getFarthestCar();
    }
}
