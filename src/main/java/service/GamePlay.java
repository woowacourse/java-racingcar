package service;

import static view.OutputView.printResultNotice;
import static view.OutputView.printWinner;

import domain.Cars;
import java.util.List;
import strategy.MovingStrategy;
import strategy.RandomMovingStrategy;
import view.InputView;
import view.OutputView;

public class GamePlay {

    public static void gameStart(List<String> carNames) {
        Cars cars = CarFactory.buildCars(carNames);
        OutputView.printInputTryTimesNotice();
        int tryTimes = InputView.inputTryTimes();
        printResultNotice();
        play(cars, tryTimes, new RandomMovingStrategy());
        printWinner(WinningRule.winner(cars.getNamesAndPositions()));
    }

    private static void play(Cars cars, int tryTimes, MovingStrategy movingStrategy) {
        for (int i = 0; i < tryTimes; i++) {
            cars.cycleCars(movingStrategy);
            OutputView.printCarNameAndPosition(cars);
        }
    }
}
