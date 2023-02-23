package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Cars cars = makeCars();
        TryCount tryCount = makeTryCount();
        outputView.printResultMessage();
        playRound(cars, tryCount);
        outputView.printWinners(cars.getWinner());
    }

    private void playRound(Cars cars, TryCount tryCount) {
        for (int i = 0; i < tryCount.getValue(); i++) {
            List<Car> roundResult = cars.runRound();
            outputView.printRoundResult(roundResult);
        }
        outputView.printRoundResult(cars.getCars());
    }

    private Cars makeCars() {
        try {
            outputView.printNameInput();
            return new Cars(inputView.readCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeCars();
        }
    }

    private TryCount makeTryCount() {
        try {
            outputView.printCountInput();
            return new TryCount(inputView.readTryCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeTryCount();
        }
    }
}
