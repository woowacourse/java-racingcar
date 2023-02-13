package controller;

import domain.Cars;
import domain.GameCount;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGameController {
    private static final int RANDOM_UPPER_BOUND_EXCLUSIVE = 10;

    private GameCount gameCount;
    private Cars cars;
    private final Random powerGenerator = new Random();

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
            cars.move(generatePowers());
            gameCount.play();
            outputView.printRaceResult(cars.getResult());
        }

        outputView.printWinners(cars.getWinners());
    }

    private List<Integer> generatePowers() {
        int carsSize=cars.size();

        return IntStream.range(0, carsSize)
                .map(o -> powerGenerator.nextInt(RANDOM_UPPER_BOUND_EXCLUSIVE))
                .boxed()
                .collect(Collectors.toUnmodifiableList());
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
