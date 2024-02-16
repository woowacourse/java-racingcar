package controller;

import domain.CarFactory;
import domain.Cars;
import domain.RandomNumber;
import domain.Rap;
import domain.Winners;
import util.StringConvertor;
import view.ExceptionRetryHandler;
import view.InputView;
import view.OutputView;

public class RacingController {
    private static final int MIN_NUMBER_RANGE = 0;
    private static final int MAX_NUMBER_RANGE = 9;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = createCars(receiveCarNames());
        Rap rap = createRap(receiveTryCount());
        racing(cars, rap);
        outputView.printWinners(Winners.from(cars));
    }

    private String receiveCarNames() {
        outputView.printCarNamesInputText();
        return ExceptionRetryHandler.retryUntilValid(inputView::readCarNames);
    }

    private Cars createCars(String carNames) {
        String[] cars = StringConvertor.splitByDelimiter(carNames, StringConvertor.getDelimiter());
        CarFactory carFactory = CarFactory.from(cars);
        return new Cars(carFactory.getProducedCars());
    }

    private int receiveTryCount() {
        outputView.printTryCountInputText();
        return ExceptionRetryHandler.retryUntilValid(inputView::readTryCount);
    }

    private Rap createRap(int tryCount) {
        return new Rap(tryCount);
    }

    private void racing(Cars cars, Rap rap) {
        outputView.printRacingResult();
        while (rap.isLeft()) {
            RandomNumber randomNumber = RandomNumber.of(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
            cars.moveAll(randomNumber);
            outputView.printRacingProceed(cars);
            rap.round();
        }
    }
}
