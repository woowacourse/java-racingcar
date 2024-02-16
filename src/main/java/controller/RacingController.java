package controller;

import domain.Attempt;
import domain.Cars;
import domain.NumberGenerator;
import domain.RandomNumberGenerator;
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
        Cars cars = ExceptionRetryHandler.retryUntilValid(this::receiveCarNames);
        Attempt attempt = ExceptionRetryHandler.retryUntilValid(this::receiveTryCount);
        racing(cars, attempt);
        outputView.printWinners(Winners.from(cars));
    }

    private Cars receiveCarNames() {
        outputView.printCarNamesInputText();
        String carNames = inputView.readCarNames();
        return Cars.from(StringConvertor.convertListSplitByComma(carNames));
    }

    private Attempt receiveTryCount() {
        outputView.printTryCountInputText();
        return Attempt.from(inputView.readTryCount());
    }

    private void racing(Cars cars, Attempt attempt) {
        outputView.printRacingResult();
        int attemptCount = attempt.getCount();
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        while (attemptCount != 0) {
            cars.moveAll(randomNumberGenerator);
            outputView.printRacingProceed(cars);
            attemptCount--;
        }
    }
}
