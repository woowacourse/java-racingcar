package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingCarController {
    private NumberGenerator numberGenerator;

    public RacingCarController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

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
        RacingCarNames racingCarNames = readRacingCarNames();
        return racingCarNames.createRacingCars(numberGenerator);
    }

    private RacingCarNames readRacingCarNames() {
        String carNames = InputView.inputCarNames();
        return new RacingCarNames(carNames);
    }

    private TryNumber readTryNumber() {
        String input = InputView.inputMoveCount();
        return new TryNumber(Integer.parseInt(input));
    }
}
