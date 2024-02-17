package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.NumericGenerator;
import racingcar.model.TryCount;
import racingcar.model.numericgenerator.RandomNumericGenerator;
import racingcar.view.OutputView;

public class CarController {
    private Cars cars;
    private TryCount tryCount;
    private NumericGenerator generator = new RandomNumericGenerator();

    public CarController(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void startGame() {
        OutputView.printResultMessage();

        while (tryCount.checkTryable()) {
            cars.moveCars(generator);
            OutputView.printCarStatus(cars);
            tryCount.consume();
        }

        OutputView.printWinner(cars.calculateWinner());
    }
}
