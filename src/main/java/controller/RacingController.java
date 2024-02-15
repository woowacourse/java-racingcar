package controller;

import domain.Cars;
import util.StringConvertor;
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
        outputView.printCarNamesInputText();
        String carNames = inputView.readCarNames();
        Cars cars = Cars.from(StringConvertor.convertListSplitByComma(carNames));
        outputView.printTryCountInputText();
        int tryCount = inputView.readTryCount();

        outputView.printRacingResult();
        while (tryCount != 0) {
            cars.moveAll();
            outputView.printRacingProceed(cars);
            tryCount--;
        }

        outputView.printWinners(cars.getWinners());
    }
}
