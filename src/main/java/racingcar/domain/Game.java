package racingcar.domain;

import racingcar.service.DetermineMovementByRandomNumber;
import racingcar.service.MoveOrStop;
import racingcar.view.InputView.InputView;

import java.util.List;

public class Game {
    private final Cars cars;
    private final TrialCount trialCount;
    private final MoveOrStop moveOrStop;

    public Game(List<String> inputCarNames, int inputTrialCount, DetermineMovementByRandomNumber moveOrStop) {
        cars = new Cars(inputCarNames);
        trialCount = new TrialCount(inputTrialCount);
        this.moveOrStop = moveOrStop;
    }

    public boolean isContinue() {
        return this.trialCount.isRemain();
    }

    public void playOneSet() {
        this.cars.move(moveOrStop);
        this.trialCount.minus();
    }

    public List<Car> now() {
        return cars.getCars();
    }

    public List<Car> winnerCars() {
        return cars.getFarthestCars();
    }
}
