package controller;

import domain.*;
import domain.RacingCars;
import domain.TryNumber;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingCarController {
    private final NumberGenerator numberGenerator;
    private final RacingCarFactory racingCarFactory;

    public RacingCarController(final NumberGenerator numberGenerator, final RacingCarFactory racingCarFactory) {
        this.numberGenerator = numberGenerator;
        this.racingCarFactory = racingCarFactory;
    }

    public void start() {
        RacingCars racingCars = readRacingCars();
        TryNumber tryNumber = readTryNumber();

        OutputView.printRacingStartMessage();
        do {
            tryRace(racingCars);
            tryNumber.decrease();
        } while(tryNumber.isTryable());

        List<String> winners = racingCars.getWinners();
        OutputView.printWinners(winners);
    }

    private void tryRace(final RacingCars racingCars) {
        List<RaceResult> results = racingCars.tryRace(numberGenerator);
        printResult(results);
    }

    private RacingCars readRacingCars() {
        RacingCarNames carNames = new RacingCarNames(InputView.inputCarNames());
        return new RacingCars(racingCarFactory.createBy(carNames));
    }

    private TryNumber readTryNumber() {
        String input = InputView.inputMoveCount();
        try {
            return new TryNumber(Integer.parseInt(input));
        } catch(NumberFormatException numberFormatException) {
            throw new NumberFormatException("시도횟수는 숫자만 입력가능합니다.");
        }
    }

    private void printResult(List<RaceResult> raceResults) {
        raceResults.forEach(raceResult -> OutputView.printResult(raceResult.name(), raceResult.moveCount()));
        System.out.println();
    }
}
