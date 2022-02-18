package racingcar.domain;

import racingcar.service.DetermineMovementByRandomNumber;
import racingcar.service.MoveOrStop;
import racingcar.view.InputView.InputView;
import racingcar.view.OutputView.OutputView;

import java.util.List;

public class Game {
    private final Cars cars;
    private final TrialCount trialCount;
    private final MoveOrStop moveOrStop;

    public Game(InputView inputView, DetermineMovementByRandomNumber moveOrStop){
        cars = new Cars(inputView.inputCarNames());
        trialCount = new TrialCount(inputView.inputTrialCount());
        this.moveOrStop = moveOrStop;
    }

    public boolean isContinue() {
        return this.trialCount.getTrialCount() > 0;
    }

    public void carsMove() {
        this.cars.move(moveOrStop);
        this.trialCount.minus();
    }

    public List<Car> now(){
        return cars.getCars();
    }

    public List<Car> winnerCars(){
        return cars.getFarthestCars();
    }
}
