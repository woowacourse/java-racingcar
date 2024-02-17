package racingcar.controller;

import racingcar.controller.numericgenerator.RandomNumericGenerator;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private Cars cars;
    private TryCount tryCount;

    public void startGame() {
        String receivedCarNames = InputView.inputRacingCars();
        cars = new Cars(receivedCarNames);

        String receivedCount = InputView.inputTryCount();
        tryCount = new TryCount(receivedCount);

        OutputView.printResultMessage();
        while(tryCount.checkTryable()){
            cars.moveCars(new RandomNumericGenerator());
            OutputView.printCarStatus(cars);
            tryCount.consume();
        }

        OutputView.printWinner(cars.calculateWinner());
    }
}
