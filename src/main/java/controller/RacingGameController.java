package controller;

import domain.Cars;
import domain.MoveCount;
import domain.MovingPolicy;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;

    private final MovingPolicy movingPolicy;
    private Cars cars;
    private MoveCount moveCount;

    public RacingGameController(InputView inputView, OutputView outputView, MovingPolicy movingPolicy) {
        this.movingPolicy = movingPolicy;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        init();
        play();
    }

    private void init() {
        repeater(this::readCarNames);
        repeater(this::readMoveCount);
        outputView.initResult();
    }

    private void readCarNames() {
        cars = Cars.from(inputView.readCarName());
    }

    private void readMoveCount() {
        moveCount = new MoveCount(inputView.readTryCount());
    }

    private void play() {
        while (!moveCount.isOver()) {
            cars.move(movingPolicy);
            moveCount.decrease();
            outputView.printRaceResult(cars.getResult());
        }

        outputView.printWinners(cars.getWinners());
    }

    private void repeater(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            outputView.printError(e.getMessage());
            repeater(runnable);
        }
    }
}
