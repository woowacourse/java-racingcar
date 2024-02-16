package controller;

import domain.Attempt;
import domain.RandomMovingCars;
import domain.Winners;
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
        RandomMovingCars randomMovingCars = ExceptionRetryHandler.retryUntilValid(this::receiveCarNames);
        Attempt attempt = ExceptionRetryHandler.retryUntilValid(this::receiveTryCount);
        racing(randomMovingCars, attempt);
        outputView.printWinners(Winners.from(randomMovingCars));
    }

    private RandomMovingCars receiveCarNames() {
        outputView.printCarNamesInputText();
        String carNames = inputView.readCarNames();
        return RandomMovingCars.from(StringConvertor.convertListSplitByComma(carNames));
    }

    private Attempt receiveTryCount() {
        outputView.printTryCountInputText();
        return Attempt.from(inputView.readTryCount());
    }

    private void racing(RandomMovingCars randomMovingCars, Attempt attempt) {
        outputView.printRacingResult();
        int attemptCount = attempt.getCount();
        while (attemptCount != 0) {
            randomMovingCars.moveAll();
            outputView.printRacingProceed(randomMovingCars);
            attemptCount--;
        }
    }
}
