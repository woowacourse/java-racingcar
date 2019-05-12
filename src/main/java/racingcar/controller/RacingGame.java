package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int tryCount;

    public void playGame() {
        CarProcessing carProcessing = new CarProcessing();

        prepareGame(carProcessing);
        OutputView.printRacingResultTitle();
        startGame(carProcessing);
        OutputView.printWinner(new RacingResult(cars));
    }

    private void prepareGame(CarProcessing carProcessing) {
        CarNames carNames = InputView.InputCarNames();

        cars = carProcessing.createCar(carNames.getName());
        tryCount = InputView.InputRacingTryCount().getCount();
    }

    private void startGame(CarProcessing carProcessing) {
        for (int i = 0; i < tryCount; i++) {
            carProcessing.race();
            OutputView.printRacingResult(cars);
        }
    }

}
