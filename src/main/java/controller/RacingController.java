package controller;

import domain.Cars;
import domain.RandomNumberGenerator;
import util.StringConvertor;
import view.ExceptionRetryHandler;
import view.InputView;
import view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = ExceptionRetryHandler.retryUntilValid(this::receiveCarNames);
        int tryCount = ExceptionRetryHandler.retryUntilValid(this::receiveTryCount);

        outputView.printRacingResult();
        while (tryCount != 0) {
            cars.moveAll(new RandomNumberGenerator());
            outputView.printRacingProceed(cars);
            tryCount--;
        }

        outputView.printWinners(cars.getWinners());
    }

    private Cars receiveCarNames() {
        outputView.printCarNamesInputText();
        String carNames = inputView.readCarNames();
        return Cars.from(StringConvertor.convertListSplitByComma(carNames));
    }

    private int receiveTryCount() {
        outputView.printTryCountInputText();
        return inputView.readTryCount();
    }
}
