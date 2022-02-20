package racingcar.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.ParticipatedCars;
import racingcar.domain.RacingGame;
import racingcar.dto.RacingResultsDto;
import racingcar.dto.WinnerNamesDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void playGame() {
        RacingGame racingGame = initRacingGame();
        executeRacingAndPrintResults(racingGame);

        OutputView.printWinnerNames(getWinnerNamesOfRacing(racingGame));
    }

    private RacingGame initRacingGame() {
        String carNamesLine = InputView.inputCarNames();
        String trialCountLine = InputView.inputTrials();
        return RacingGame.of(carNamesLine, trialCountLine);
    }

    private void executeRacingAndPrintResults(RacingGame racingGame) {
        OutputView.printResultMessage();
        while (racingGame.canRaceMore()) {
            racingGame.raceOnce();
            OutputView.printRacingResults(getResultsOfRacing(racingGame));
        }
    }

    private WinnerNamesDto getWinnerNamesOfRacing(RacingGame racingGame) {
        ParticipatedCars participatedCars = racingGame.getParticipatedCars();
        List<String> names = participatedCars.getWinnerNames();
        return new WinnerNamesDto(names);
    }

    private RacingResultsDto getResultsOfRacing(RacingGame racingGame) {
        ParticipatedCars participatedCars = racingGame.getParticipatedCars();
        Map<String, Integer> results = participatedCars.getCars()
                .stream()
                .collect(getResultCollector());
        return new RacingResultsDto(results);
    }

    private Collector<Car, ?, Map<String, Integer>> getResultCollector() {
        return Collectors.toMap(Car::getName, Car::getPosition);
    }
}
