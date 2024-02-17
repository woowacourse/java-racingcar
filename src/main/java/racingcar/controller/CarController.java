package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.GameResult;
import racingcar.model.GameStatus;
import racingcar.model.NumericGenerator;
import racingcar.model.TryCount;
import racingcar.model.numericgenerator.RandomNumericGenerator;
import racingcar.view.OutputView;

import java.util.List;
import java.util.ArrayList;

public class CarController {
    private Cars cars;
    private TryCount tryCount;
    private NumericGenerator generator = new RandomNumericGenerator();
    private List<GameStatus> gameStatus = new ArrayList<>();

    public CarController(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void startGame() {
        OutputView.printResultMessage();

        while (tryCount.checkTryable()) {
            cars.moveCars(generator);
            gameStatus.add(cars.getGameStatus());
            tryCount.consume();
        }
    }

    public GameResult getGameResult() {
        return new GameResult(gameStatus, cars.calculateWinner());
    }
}
