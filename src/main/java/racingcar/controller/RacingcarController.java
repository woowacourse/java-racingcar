package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingGame racingGame = new RacingGame();

    public void run() {
        Cars cars = retryOnException(this::readCars);
        Round round = retryOnException(this::readRound);

        List<Cars> roundResults = simulateCarsInRound(round, cars);
        awardWinners(cars, roundResults);
    }

    private Cars readCars() {
        List<String> carNames = inputView.readCarNames();
        return racingGame.registerCars(carNames);
    }

    private Round readRound() {
        return new Round(inputView.readTryCount());
    }

    private List<Cars> simulateCarsInRound(Round round, Cars cars) {
        List<Cars> roundResults = new ArrayList<>();

        while (round.isRemain()) {
            Cars carPerformance = racingGame.processRound(cars);
            roundResults.add(carPerformance);
            round.decreaseCount();
        }
        return roundResults;
    }

    private void awardWinners(Cars cars, List<Cars> roundResults) {
        List<String> winners = racingGame.pickOutWinners(cars);
        outputView.printRoundResults(roundResults);
        outputView.printWinners(winners);
    }

    public <T> T retryOnException(Supplier<T> retryOperation) {
        try {
            return retryOperation.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return retryOnException(retryOperation);
        }
    }
}
