package controller;

import domain.Cars;
import domain.MoveCount;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    private MoveCount count;
    private Cars cars;

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void init() {
        while (!readCarNames()) ;
        while (!readTryCount()) ;
    }

    public void run() {
        outputView.initResult();

        while (!count.isOver()) {
            cars.move();
            count.decrease();
            outputView.printRaceResult(cars.getResult());
        }

        outputView.printWinners(cars.getWinners());
    }

    private boolean readCarNames() {
        try {
            this.cars = Cars.from(inputView.readCarName());
            return true;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }

        return false;
    }

    private boolean readTryCount() {
        try {
            this.count = new MoveCount(inputView.readTryCount());
            return true;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }

        return false;
    }
}
