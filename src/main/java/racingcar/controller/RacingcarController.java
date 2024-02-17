package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import racingcar.domain.Car;
import racingcar.domain.Round;
import racingcar.dto.RoundResult;
import racingcar.service.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingcarService racingcarService = new RacingcarService();

    public void run() {
        List<Car> cars = retryOnException(this::readCars);
        Round round = retryOnException(this::readRound);

        List<RoundResult> roundResults = simulateCarsInRound(round, cars);
        awardWinners(cars, roundResults);
    }

    private List<Car> readCars() {
        List<String> carNames = inputView.readCarNames();
        return racingcarService.createCars(carNames);
    }

    private Round readRound() {
        return new Round(inputView.readTryCount());
    }

    private List<RoundResult> simulateCarsInRound(Round round, List<Car> cars) {
        List<RoundResult> roundResults = new ArrayList<>();
        while (round.isRemain()) {
            RoundResult roundResult = racingcarService.processRound(cars);
            roundResults.add(roundResult);
            round.decreaseCount();
        }
        return roundResults;
    }

    private void awardWinners(List<Car> cars, List<RoundResult> roundResults) {
        List<String> winners = racingcarService.pickOutWinners(cars);
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
