package controller;

import domain.*;
import domain.RacingCars;
import domain.TryNumber;
import dto.RaceResult;
import dto.RacingCarNames;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingCarController {
    private final NumberGenerator numberGenerator;
    private final RacingCarMapper racingCarMapper;

    public RacingCarController(final NumberGenerator numberGenerator, final RacingCarMapper racingCarMapper) {
        this.numberGenerator = numberGenerator;
        this.racingCarMapper = racingCarMapper;
    }

    public void start() {
        RacingCars racingCars = readRacingCars();
        TryNumber tryNumber = readTryNumber();

        OutputView.printRacingStartMessage();
        do {
            tryRace(racingCars);
            tryNumber.decrease();
        } while(tryNumber.isTryable());

        List<RacingCar> winners = racingCars.getWinners();
        OutputView.printWinners(racingCarMapper.mapToWinners(winners));
    }

    private void tryRace(final RacingCars racingCars) {
        List<RacingCar> triedRace = racingCars.tryRace(numberGenerator);
        printResult(racingCarMapper.mapToResults(triedRace));
    }

    private RacingCars readRacingCars() {
        RacingCarNames carNames = new RacingCarNames(InputView.inputCarNames());
        return new RacingCars(racingCarMapper.mapToRacingCars(carNames));
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
