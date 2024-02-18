package racingcar.controller;

import java.util.function.Supplier;

import racingcar.domain.CarMoveRule;
import racingcar.domain.CarRacingGame;
import racingcar.domain.Cars;
import racingcar.domain.DefaultCarMoveRule;
import racingcar.exception.ExceptionHandler;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Controller {

    private final InputView inputView;
    private final ResultView resultView;
    private final ExceptionHandler exceptionHandler;

    public Controller(InputView inputView, ResultView resultView, ExceptionHandler exceptionHandler) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.exceptionHandler = exceptionHandler;
    }

    public void run() {
        Cars cars = createCars();
        CarRacingGame carRacingGame = createRacingGame(cars);
        CarMoveRule carMoveRule = new DefaultCarMoveRule();
        resultView.printProgressGuide();
        while (!carRacingGame.isGameOver()) {
            carRacingGame.decreaseMoveCount();
            carRacingGame.moveCars(carMoveRule);
            resultView.printProgress(cars);
        }
        Cars winners = carRacingGame.findWinners();
        resultView.printWinners(winners);
    }

    private Cars createCars() {
        return runWithExceptionHandler(inputView::askCarNames);
    }

    private CarRacingGame createRacingGame(Cars cars) {
        return runWithExceptionHandler(() -> {
            int moveCount = inputView.askMoveCount();
            return new CarRacingGame(cars, moveCount);
        });
    }

    private <T> T runWithExceptionHandler(Supplier<T> callback) {
        return exceptionHandler.run(callback);
    }
}
