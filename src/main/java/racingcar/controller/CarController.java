package racingcar.controller;

import racingcar.controller.numericgenerator.RandomNumericGenerator;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private Cars cars;
    private TryCount tryCount;

    public void startGame() {
        String receivedCarNames = InputView.inputRacingCars();
        cars = new Cars(new RandomNumericGenerator(), receivedCarNames);

        String receivedCount = InputView.inputTryCount();
        tryCount = new TryCount(receivedCount);

        OutputView.printResultMessage();
        while(tryCount.untilZero()){
            cars.moveCars();
            OutputView.printCarStatus(cars);
            tryCount.consume();
        }

        OutputView.printWinner(cars.calculateWinner());
    }
}
