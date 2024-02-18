package controller;

import domain.Car;
import domain.CarFactory;
import domain.Cars;
import domain.NumberGenerator;
import domain.RandomNumberGenerator;
import domain.Rap;
import domain.Winners;
import util.StringConvertor;
import view.ExceptionRetryHandler;
import view.InputView;
import view.OutputView;

public class RacingController {
    private static final int INITIAL_RETRY_COUNT = 0;
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
        return ExceptionRetryHandler.retryUntilValid(inputView::readCarNames, INITIAL_RETRY_COUNT);
    }

    private Cars createCars(final String carNames) {
        String[] cars = StringConvertor.splitByDelimiter(carNames, StringConvertor.getDelimiter());
        CarFactory carFactory = CarFactory.from(cars);
        return new Cars(carFactory.getProducedCars());
    }

    private int receiveTryCount() {
        outputView.printTryCountInputText();
        return ExceptionRetryHandler.retryUntilValid(inputView::readTryCount, INITIAL_RETRY_COUNT);
    }

    private Rap createRap(final int tryCount) {
        return new Rap(tryCount);
    }

    private void racing(final Cars cars, final Rap rap) {
        outputView.printRacingResult();
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        while (rap.isLeft()) {
            cars.moveAll(randomNumberGenerator);
            outputView.printRacingProceed(cars);
            rap.round();
        }
    }
}
