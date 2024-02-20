package racingcar.controller;

import java.util.function.Supplier;

import racingcar.exception.ExceptionHandler;
import racingcar.domain.rules.CarMoveRule;
import racingcar.domain.model.Cars;
import racingcar.domain.rules.DefaultCarMoveRule;
import racingcar.domain.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ExceptionHandler exceptionHandler;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.exceptionHandler = new ExceptionHandler();
    }

    public void run() {
        Cars cars = createCars();
        RacingGame racingGame = createRacingGame(cars);
        CarMoveRule carMoveRule = new DefaultCarMoveRule();
        outputView.printProgressGuide();

        while (racingGame.isRoundInProgress()) {
            racingGame.move(carMoveRule);
            outputView.printProgress(cars);
        }

        outputView.printWinners(racingGame.findWinners());
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
