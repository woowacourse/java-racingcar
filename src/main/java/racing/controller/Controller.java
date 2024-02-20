package racing.controller;

import racing.domain.Cars;
import racing.domain.RandomMoveStrategy;
import racing.domain.TryCount;
import racing.view.InputView;
import racing.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        Cars cars = new Cars(inputView.readNames(), new RandomMoveStrategy());
        TryCount tryCount = new TryCount(inputView.readTryCount());

        proceedRace(cars, tryCount);

        outputView.printWinners(cars.findWinners());
    }

    public void proceedRace(Cars cars, TryCount tryCount) {
        outputView.printResult();
        while (tryCount.isRemain()) {
            tryCount.consume();
            cars.proceedRound();
            outputView.printOngoingResult(cars.getCars());
        }
    }
}
