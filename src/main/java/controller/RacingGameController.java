package controller;

import domain.Cars;
import domain.GameCount;
import view.InputView;
import view.OutputView;

import java.util.Random;

public class RacingGameController {
    private GameCount gameCount;
    private Cars cars;

    private final Random powerGenerator=new Random();
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void init() {
        this.cars=makeCars();
        this.gameCount=makeGameCount();
    }

    public void run() {
        outputView.initResult();

        while (!gameCount.isOver()) {
            cars.move(powerGenerator);
            gameCount.play();
            outputView.printRaceResult(cars.getResult());
        }

        outputView.printWinners(cars.getWinners());
    }

    private Cars makeCars() {
        try {
            return Cars.from(inputView.readCarNames());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());

            return makeCars();
        }
    }

    private GameCount makeGameCount() {
        try {
            return new GameCount(inputView.readTryCount());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());

            return makeGameCount();
        }
    }
}
