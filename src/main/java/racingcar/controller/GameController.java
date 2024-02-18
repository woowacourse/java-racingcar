package racingcar.controller;

import racingcar.controller.numericgenerator.RandomNumericGenerator;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private Cars cars;
    private TryCount tryCount;

    public void play() {
        receiveInput();
        moveCars();
        showWinners();
    }

    public void receiveInput() {
        List<String> receivedCarNames = InputView.inputRacingCars();
        String receivedTryCount = InputView.inputTryCount();

        cars = new Cars(new RandomNumericGenerator(), receivedCarNames);
        tryCount = new TryCount(receivedTryCount);
    }

    public void moveCars() {
        List<List<Integer>> gameResults = new ArrayList<>();

        int totalAttempts = tryCount.getValue();
        for(int attempt = 0; attempt < totalAttempts; attempt++) {
            cars.move();
            gameResults.add(cars.getCarPositions());
        }

        OutputView.printGameResults(cars.getNames(), gameResults);
    }

    public void showWinners() {
        List<String> winners = cars.calculateWinner();

        OutputView.printWinners(winners);
    }
}
