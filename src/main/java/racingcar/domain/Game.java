package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    public void run() {
        Names names = InputView.getNames();
        Trial trial = InputView.getTrial();

        Cars cars = new Cars(names);

        OutputView.printCurrentResultTitle();
        for (int i = 0; i < trial.getTrial(); i++) {
            cars.moveCars(Random.createRandomValue());
            OutputView.printIntermediateResult(cars);
        }
        Winners.selectWinners(cars.getCars());
        OutputView.printWinnerResult();
    }
}
