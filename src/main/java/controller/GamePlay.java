package controller;

import static view.OutputView.printResultNotice;
import static view.OutputView.printWinner;

import domain.Cars;
import genertor.NumberGenerator;
import genertor.RandomNumberGenerator;
import service.CarFactory;
import view.InputView;
import view.OutputView;

public class GamePlay {

    private static final int MIN_TRYTIMES = 1;
    private static final String NOTICE_TRYTIMES = "[ERROR] 시도 횟수는 최소 1회 이상입니다.";

    public void gameStart() {
        OutputView.printInputCarNamesNotice();
        Cars cars = new Cars(CarFactory.buildCars(InputView.inputCarNames()));
        OutputView.printInputTryTimesNotice();
        int tryTimes = InputView.inputTryTimes();
        printResultNotice();
        play(cars, tryTimes, new RandomNumberGenerator());
        printWinner(cars.findWinners());
    }

    public void play(Cars cars, int tryTimes,
        NumberGenerator numberGenerator) {
        validateTryTimes(tryTimes);
        for (int i = 0; i < tryTimes; i++) {
            cars.moveCars(numberGenerator);
            OutputView.printCarNameAndPosition(cars);
        }
    }

    private void validateTryTimes(int tryTimes) {
        if (tryTimes < MIN_TRYTIMES) {
            throw new IllegalArgumentException(NOTICE_TRYTIMES);
        }
    }
}
