package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.function.Supplier;

public class MainController {
    public void run() {
        final Cars cars = repeat(this::getInputAndCreateCars);
        final Round round = repeat(this::getInputAndCreateRound);
        final CarRacingGame carRacingGame = new CarRacingGame(cars, round);
        final NumberGenerator numberGenerator = new RandomNumberGenerator();

        OutputView.printResultMessage();

        while (!carRacingGame.isGameEnd()) {
            carRacingGame.playRound(numberGenerator);
            OutputView.printRoundResult(carRacingGame.getCurrentCarStatuses());
        }

        OutputView.printWinners(carRacingGame.findWinners());
    }

    private Cars getInputAndCreateCars() {
        final String inputCarNames = InputView.inputCarNames();
        return new Cars(inputCarNames);
    }

    private Round getInputAndCreateRound() {
        final String inputRound = InputView.inputRound();
        return new Round(inputRound);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return repeat(inputReader);
        }
    }
}
