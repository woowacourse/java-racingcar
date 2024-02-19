package racingcar.controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Supplier;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberOfPower;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {

    public void run() {
        RacingGame racingGame = initGame();
        List<Cars> roundResults = racingGame.simulateCarsInRound();
        List<String> winners = racingGame.pickOutWinners();
        printGameResult(roundResults, winners);
    }

    private RacingGame initGame() {
        Cars cars = retryOnException(this::readCars);
        Round round = retryOnException(this::readRound);
        return new RacingGame(cars, round, new RandomNumberOfPower());
    }

    private Cars readCars() {
        List<String> carNames = InputView.readCarNames();
        return carNames.stream()
                .map(Car::new)
                .collect(collectingAndThen(toList(), Cars::new));
    }

    private Round readRound() {
        return new Round(InputView.readTryCount());
    }

    private void printGameResult(List<Cars> roundResults, List<String> winners) {
        OutputView.printRoundResults(roundResults);
        OutputView.printWinners(winners);
    }

    private <T> T retryOnException(Supplier<T> retryOperation) {
        try {
            return retryOperation.get();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return retryOnException(retryOperation);
        }
    }
}
