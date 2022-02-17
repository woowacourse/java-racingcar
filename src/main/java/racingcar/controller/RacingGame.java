package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final String RESULT_PREFIX = "실행결과";
    private Cars cars = Cars.getInstance();
    private final int tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        this.tryCount = tryCount;
        cars.insertCarFromCarNames(carNames);
    }

    public void play() throws RuntimeException {
        OutputView.printMessage(RESULT_PREFIX);
        for (int i = 0; i < tryCount; i++) {
            cars.moveRound();
            printPosition();
        }
        printWinner();
    }

    private void printPosition() {
        OutputView.printResult(cars.getCars());
    }

    private void printWinner() {
        OutputView.printWinner(cars.getWinners());
    }
}
