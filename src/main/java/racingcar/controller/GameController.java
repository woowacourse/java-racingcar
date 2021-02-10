package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Result;
import racingcar.domain.Results;
import racingcar.domain.Round;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public void run() {
        Cars cars = getInputCarNames();
        Round round = getInputRoundCount();
        Results results = move(round, cars);
        Winners winners = Winners.from(results);
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
            cars.tryToMove();
            Result result = cars.getResult();
            results.add(result);
        }
        return Results.from(results);
    }
}
