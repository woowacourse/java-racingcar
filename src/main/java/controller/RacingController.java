package controller;

import domain.Rap;
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
        Rap rap = ExceptionRetryHandler.retryUntilValid(this::receiveTryCount);
        racing(cars, rap);
        outputView.printWinners(Winners.from(cars));
    }

    private Cars receiveCarNames() {
        outputView.printCarNamesInputText();
        String carNames = inputView.readCarNames();
        return Cars.from(StringConvertor.convertListSplitByComma(carNames));
    }

    private Rap receiveTryCount() {
        outputView.printTryCountInputText();
        return Rap.from(inputView.readTryCount());
    }

    private void racing(Cars cars, Rap rap) {
        outputView.printRacingResult();
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        while (rap.isLeft()) {
            cars.moveAll(randomNumberGenerator);
            outputView.printRacingProceed(cars);
            rap.round();
        }
    }
}
