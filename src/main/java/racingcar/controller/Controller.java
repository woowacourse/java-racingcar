package racingcar.controller;

import java.util.function.Supplier;

import racingcar.exception.ExceptionHandler;
import racingcar.domain.model.CarMoveRule;
import racingcar.domain.model.Cars;
import racingcar.domain.model.DefaultCarMoveRule;
import racingcar.domain.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final ExceptionHandler exceptionHandler;

    public Controller(InputView inputView, OutputView outputView, ExceptionHandler exceptionHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.exceptionHandler = exceptionHandler;
    }

    public void run() {
        Cars cars = createCars();
        RacingGame racingGame = createRacingGame(cars);
        CarMoveRule carMoveRule = new DefaultCarMoveRule();
        outputView.printProgressGuide();
        while (!racingGame.isGameOver()) {
            racingGame.move(carMoveRule);
            outputView.printProgress(cars);
        }
        Cars winners = racingGame.findWinners();
        outputView.printWinners(winners);
    }

    private Cars createCars() {
        return runWithExceptionHandler(inputView::askCarNames);
    }

    private RacingGame createRacingGame(Cars cars) {
        return runWithExceptionHandler(() -> {
            int moveCount = inputView.askMoveCount();
            return new RacingGame(cars, moveCount);
        });
    }

    private <T> T runWithExceptionHandler(Supplier<T> callback) {
        return exceptionHandler.run(callback);
    }
}
