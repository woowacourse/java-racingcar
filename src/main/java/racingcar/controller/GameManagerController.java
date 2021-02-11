package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Result;
import racingcar.domain.Results;
import racingcar.domain.Round;
import racingcar.utils.RandomUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManagerController {

    private static final int MIN_RANDOM_RANGE = 0;
    private static final int MAX_RANDOM_RANGE = 9;

    public void run() {
        Cars cars = getInputCarNames();
        Round round = getInputRoundCount();
        Results results = move(round, cars);
        List<String> winners = results.getWinners();
        OutputView.printResults(results);
        OutputView.printWinners(winners);
    }

    private Cars getInputCarNames() {
        String[] carNames = InputView.inputCarNames();
        return Cars.from(carNames);
    }

    private Round getInputRoundCount() {
        int roundCount = InputView.inputRoundCount();
        return Round.from(roundCount);
    }

    private Results move(Round round, Cars cars) {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < round.getCount(); i++) {
            List<Integer> randomValues = createRandomValues(cars.size());
            cars.tryToMove(randomValues);
            Result result = cars.getResult();
            results.add(result);
        }
        return Results.from(results);
    }

    private List<Integer> createRandomValues(int size) {
        List<Integer> randomValues = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomValue = RandomUtils.nextInt(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE);
            randomValues.add(randomValue);
        }
        return new ArrayList<>(randomValues);
    }
}
