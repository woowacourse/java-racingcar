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
            racingCars.tryRace().forEach(this::printResult);
            System.out.println();
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
        int input = InputView.inputMoveCount();
        return new TryNumber(input);
    }

    private void printResult(RaceResult raceResult) {
        OutputView.printResult(raceResult.name(), raceResult.moveNumber());
    }
}
