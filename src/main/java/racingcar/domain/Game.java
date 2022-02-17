package racingcar.domain;

import racingcar.dto.CarDto;
import racingcar.service.DetermineMovement;
import racingcar.service.MoveOrStop;
import racingcar.view.InputView.InputView;

import java.util.List;

public class Game {
    private final Cars cars;
    private int trialCount;

    public Game(InputView inputView) {
        cars = new Cars(inputView.inputCarNames());
        trialCount = inputView.inputTrialCount();
    }

    public boolean isContinue() {
        return this.trialCount > 0;
    }

    public void carsMove(MoveOrStop moveOrStop) {
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
