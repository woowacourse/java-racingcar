package controller;

import domain.Cars;
import domain.MoveCount;
import domain.NumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;

    private final NumberGenerator numberGenerator;
    private Cars cars;
    private MoveCount moveCount;

    public RacingGameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        init();
        race();
        identifyWinners();
    }

    private void init() {
        repeater(this::readCarNames);
        repeater(this::readMoveCount);
    }

    private void readCarNames() {
        cars = Cars.from(inputView.readCarNames());
    }

    private void readMoveCount() {
        moveCount = new MoveCount(inputView.readTryCount());
    }

    private void race() {
        outputView.printResultOpening();

        while (!moveCount.isFinished()) {
            cars.move(numberGenerator);
            moveCount.decrease();
            outputView.printRaceResult(cars.getCarsPosition());
        }
    }

    private void identifyWinners() {
        outputView.printWinners(cars.identifyWinners());
    }

    private void repeater(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            if (e.getClass() != IllegalArgumentException.class) {
                throw e;
            }
            outputView.printError(e.getMessage());
            repeater(runnable);
        }
    }
}
