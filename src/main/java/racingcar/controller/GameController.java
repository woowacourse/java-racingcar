package racingcar.controller;

import racingcar.controller.numericgenerator.RandomNumericGenerator;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final Cars cars;
    private final TryCount tryCount;

    public GameController(List<String> receivedCarNames, String receivedTryCount) {
        cars = new Cars(new RandomNumericGenerator(), receivedCarNames);
        tryCount = new TryCount(receivedTryCount);
    }

    public void play() {
        OutputView.printResultMessage();

        int totalAttempts = tryCount.getValue();
        for(int attempt = 0; attempt < totalAttempts; attempt++) {
            cars.moveCars();
            OutputView.printCars(cars);
        }

        OutputView.printWinners(cars.calculateWinner());
    }
}
