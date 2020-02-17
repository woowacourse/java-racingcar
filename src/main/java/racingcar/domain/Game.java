package racingcar.domain;

import racingcar.domain.Generator.CarMoveValueGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    public static final int RANDOM_LIMIT_VALUE = 10;

    private Trial trial;
    private Cars cars;
    private CarMoveValueGenerator carMoveValueGenerator = () -> (int) (Math.random() * RANDOM_LIMIT_VALUE);

    public void run() {
        prepareGame();
        playGaming();
        printFinalResult();
    }

    private void prepareGame() {
        Names names = InputView.getNames();
        trial = InputView.getTrial();
        cars = new Cars(names);
    }

    private void playGaming() {
        OutputView.printCurrentResultTitle();
        for (int i = 0; i < trial.getTrial(); i++) {
            cars.moveCars(carMoveValueGenerator);
            OutputView.printIntermediateResult(cars);
        }
    }

    private void printFinalResult() {
        cars.selectWinners();
        OutputView.printWinnerResult();
    }
}