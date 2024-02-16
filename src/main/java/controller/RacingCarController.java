package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingCarController {
    public void start() {
        RacingCars racingCars = readRacingCars();
        TryNumber tryNumber = readTryNumber();

        OutputView.printRacingStartMessage();
        do {
            racingCars.tryRace();
            tryNumber.decrease();
        } while(tryNumber.isTryable());

        List<String> winners = racingCars.getWinners();
        OutputView.printWinners(winners);
    }

    private RacingCars readRacingCars() {
        RacingCarFactory racingCarFactory = readRacingCarNames();
        return new RacingCars(racingCarFactory);
    }

    private RacingCarFactory readRacingCarNames() {
        String carNames = InputView.inputCarNames();
        return new RacingCarFactory(carNames);
    }

    private TryNumber readTryNumber() {
        String input = InputView.inputMoveCount();
        return new TryNumber(Integer.parseInt(input));
    }
}
