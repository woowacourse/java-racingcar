package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    private Names names;
    private Trial trial;
    private Cars cars;

    public void run() {
        prepareGame();
        playGaming();
        printFinalResult();
    }

    private void prepareGame(){
        names = InputView.getNames();
        trial = InputView.getTrial();
        cars = new Cars(names);
    }

    private void playGaming() {
        OutputView.printCurrentResultTitle();
        for (int i = 0; i < trial.getTrial(); i++) {
            cars.moveCars();
            OutputView.printIntermediateResult(cars);
        }
    }

    private void printFinalResult() {
        cars.selectWinners();
        OutputView.printWinnerResult();
    }
}