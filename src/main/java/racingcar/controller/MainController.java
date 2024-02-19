package racingcar.controller;

import racingcar.domain.*;
import racingcar.utils.CarNameConverter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MainController {

    public void run() {
        CarRacingGame carRacingGame = initializeCarRacingGame();
        List<RoundResult> roundResults = carRacingGame.race(new RandomNumberGenerator());

        showRoundResults(roundResults);
        showWinners(carRacingGame.findWinners());
    }

    private CarRacingGame initializeCarRacingGame() {
        Cars cars = repeatTemplate(this::initializeCars);
        Round round = repeatTemplate(this::initializeRound);

        return new CarRacingGame(cars, round);
    }

    private Cars initializeCars() {
        String inputCarNames = InputView.inputCarNames();
        List<String> carNames = CarNameConverter.convertToCarNames(inputCarNames);

        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::new));
    }

    private Round initializeRound() {
        int inputRound = InputView.inputRound();
        return new Round(inputRound);
    }

    private void showRoundResults(List<RoundResult> roundResults) {
        OutputView.printResultMessage();

        roundResults.forEach(roundResult -> {
            OutputView.printRoundResult(roundResult.getRoundResult());
        });
    }

    private void showWinners(List<String> winners) {
        OutputView.printWinners(winners);
    }

    private <T> T repeatTemplate(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return repeatTemplate(inputReader);
        }
    }
}
