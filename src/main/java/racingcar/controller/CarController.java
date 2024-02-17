package racingcar.controller;

import racingcar.controller.numericgenerator.RandomNumericGenerator;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarController {
    public void startGame() {
        List<String> receivedCarNames = InputView.inputRacingCars();
        Cars cars = new Cars(new RandomNumericGenerator(), receivedCarNames);
        String receivedCount = InputView.inputTryCount();
        TryCount tryCount = new TryCount(receivedCount);

        OutputView.printResultMessage();
        while (tryCount.untilZero()) {
            cars.moveCars();
            OutputView.printCarStatus(cars);
            tryCount.consume();
        }

        OutputView.printWinner(cars.calculateWinner());
    }
}
