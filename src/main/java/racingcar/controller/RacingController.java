package racingcar.controller;

import java.util.Collections;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private static final int WRONG_TRY_COUNT = 0;

    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void doRacing() {
        createCars();
        repeatTryMovingByInputCount();
        outputView.printResult(cars.getStatuses());
        outputView.printWinner(cars.getWinner());
    }

    private void createCars() {
        try {
            this.cars = new Cars(inputView.inputCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createCars();
        }
    }

    private void repeatTryMovingByInputCount() {
        int tryCount;
        do {
            tryCount = getTryCount();
        } while (tryCount == WRONG_TRY_COUNT);
        outputView.announceBeforePrintResult();
        for (int i = 0; i < tryCount; i++) {
            cars.requestMoveEachCar();
            outputView.printResult(cars.getStatuses());
        }
    }

    private int getTryCount() {
        int tryCount;
        try {
            tryCount = inputView.getTryCount();
            return tryCount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return WRONG_TRY_COUNT;
        }
    }


}
