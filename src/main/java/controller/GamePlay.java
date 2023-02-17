package controller;

import static view.OutputView.printResultNotice;
import static view.OutputView.printWinner;

import domain.Cars;
import genertor.NumberGenerator;
import view.InputView;
import view.OutputView;

public class GamePlay {

    private final Cars cars;
    private final NumberGenerator numberGenerator;

    public GamePlay(Cars cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void gameStart() {
        OutputView.printInputCarNamesNotice();
        OutputView.printInputTryTimesNotice();
        int tryTimes = InputView.inputTryTimes();
        printResultNotice();
        play(cars, tryTimes);
        printWinner(cars.findWinners());
    }

    public void play(Cars cars, int tryTimes) {
        validateTryTimes(tryTimes);
        while (tryTimes-- > 0) {
            cars.moveCars(numberGenerator);
            OutputView.printCarNameAndPosition(cars);
        }
    }

    private void validateTryTimes(int tryTimes) {
        if (tryTimes < 1) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 최소 1회 이상입니다.");
        }
    }
}
