package racingcar.controller;

import racingcar.controller.numericgenerator.RandomNumericGenerator;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private Cars cars;
    private TryCount tryCount;

    public void receiveInput() {
        List<String> receivedCarNames = InputView.inputRacingCars();
        String receivedTryCount = InputView.inputTryCount();

        cars = new Cars(new RandomNumericGenerator(), receivedCarNames);
        tryCount = new TryCount(receivedTryCount);
    }

    public void play() {
        receiveInput();

        OutputView.printResultMessage();

        int totalAttempts = tryCount.getValue();
        for(int attempt = 0; attempt < totalAttempts; attempt++) {
            cars.moveCars();
            OutputView.printCars(cars);
        }

        OutputView.printWinners(cars.calculateWinner());
    }
}
