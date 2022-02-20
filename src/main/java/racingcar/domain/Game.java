package racingcar.domain;

import racingcar.service.DetermineMovementByRandomNumber;
import racingcar.service.MoveOrStop;
import racingcar.view.InputView.InputView;

import java.util.List;

public class Game {
    private final Cars cars;
    private final TrialCount trialCount;
    private final MoveOrStop moveOrStop;

    public Game(InputView inputView, DetermineMovementByRandomNumber moveOrStop) {
        cars = new Cars(inputView.inputCarNames());
        trialCount = new TrialCount(inputView.inputTrialCount());
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
