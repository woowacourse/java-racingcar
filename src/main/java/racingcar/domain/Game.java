package racingcar.domain;

import racingcar.dto.CarDto;
import racingcar.service.DetermineMovement;
import racingcar.service.MoveOrStop;
import racingcar.view.InputView.InputView;

import java.util.List;

public class Game {
    private final Cars cars;
    private int trialCount;
    private final MoveOrStop moveOrStop;

    public Game(InputView inputView,DetermineMovement moveOrStop){
        cars = new Cars(inputView.inputCarNames());
        trialCount = inputView.inputTrialCount();
        this.moveOrStop = moveOrStop;
    }

    public boolean isContinue() {
        return this.trialCount > 0;
    }

    public void carsMove() {
        this.cars.move(moveOrStop);
        this.trialCount--;
    }

    public List<CarDto> carsInfo() {
        return cars.getCarInfos();
    }

    public List<CarDto> winnerCarsInfo() {
        return cars.getFarthestCars();
    }

}
