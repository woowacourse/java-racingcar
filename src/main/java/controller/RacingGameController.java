package controller;

import domain.Cars;
import domain.GameCount;
import view.InputView;
import view.OutputView;

import java.util.Optional;

public class RacingGameController {
    private GameCount gameCount;
    private Cars cars;

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void init() {
        initCars();
        initGameCount();
    }

    public void run() {
        outputView.initResult();

        while (!gameCount.isOver()) {
            cars.move();
            gameCount.play();
            outputView.printRaceResult(cars.getResult());
        }

        outputView.printWinners(cars.getWinners());
    }

    private void initCars() {
        Optional<Cars> cars = makeCars();
        while (cars.isEmpty())
            cars = makeCars();

        this.cars = cars.get();
    }

    private void initGameCount() {
        Optional<GameCount> gameCount = makeGameCount();
        while (gameCount.isEmpty())
            gameCount = makeGameCount();

        this.gameCount = gameCount.get();
    }

    private Optional<Cars> makeCars() {
        try {
            return Optional.of(Cars.from(inputView.readCarName()));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());

            return Optional.empty();
        }
    }

    private Optional<GameCount> makeGameCount() {
        try {
            return Optional.of(new GameCount(inputView.readTryCount()));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());

            return Optional.empty();
        }
    }
}
