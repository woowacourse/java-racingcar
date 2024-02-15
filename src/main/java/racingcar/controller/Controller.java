package racingcar.controller;

import static racingcar.utils.Random.THRESHOLD;

import java.util.function.Supplier;

import racingcar.exception.ExceptionHandler;
import racingcar.model.Cars;
import racingcar.model.CarMoveRule;
import racingcar.model.RacingGame;
import racingcar.utils.Random;
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
        Cars cars = runWithExceptionHandler(inputView::askCarNames);
        RacingGame racingGame = runWithExceptionHandler(() -> createRacingGame(cars));
        CarMoveRule carMoveRule = () -> Random.pickNumber() >= THRESHOLD;
        outputView.printProgressGuide();
        while (!racingGame.isGameOver()) {
            racingGame.move(carMoveRule);
            outputView.printProgress(cars);
        }
        Cars winners = racingGame.findWinners();
        outputView.printWinners(winners);
    }

    private RacingGame createRacingGame(Cars cars){
        int moveCount = inputView.askMoveCount();
        return new RacingGame(cars, moveCount);
    }

    private <T> T runWithExceptionHandler(Supplier<T> callback) {
        return exceptionHandler.run(callback);
    }
}
