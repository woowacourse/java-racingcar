package racingcar.controller;

import racingcar.controller.numericgenerator.RandomNumericGenerator;
import racingcar.model.Cars;
import racingcar.model.GameResult;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public void play() {
        Cars cars = new Cars(new RandomNumericGenerator(), InputView.inputRacingCars());
        TryCount tryCount = new TryCount(InputView.inputTryCount());
        GameResult gameResult = new GameResult();

        int totalAttempts = tryCount.getValue();
        for(int attempt = 0; attempt < totalAttempts; attempt++) {
            cars.move();
            gameResult.addResult(cars.getPositions());
        }

        OutputView.printGameResults(cars.getNames(), gameResult.getGameResult());
        OutputView.printWinners(gameResult.getWinners(cars.getNames()));
    }
}
