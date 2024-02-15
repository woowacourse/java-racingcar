package controller;

import domain.RacingCar;
import domain.RacingCarNames;
import domain.RacingCars;
import domain.TryNumber;
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
        RacingCarNames racingCarNames = readRacingCarNames();
        return racingCarNames.createRacingCars();
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
