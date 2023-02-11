package controller;

import domain.Cars;
import domain.MovementManager;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;
import java.util.List;

public class RacingController {
    private final OutputView outputView;
    private final InputView inputView;

    public RacingController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        Cars cars = setUpCarName();
        Integer tryCount = setUpTryCount();
        progressRacingGame(tryCount, cars, new RandomNumberGenerator());
    }

    private void progressRacingGame(Integer tryCount, Cars cars, RandomNumberGenerator randomNumberGenerator) {
        MovementManager movementManager = new MovementManager();
        outputView.printResultGuideMessage();
        for (int round = 0; round < tryCount; round++) {
            cars.progressRound(randomNumberGenerator, movementManager);
            outputView.printCurrentResult(cars);
        }
        List<String> winners = cars.findWinners();
        outputView.printFinalResult(cars, winners);
    }

    private Cars setUpCarName() {
        try {
            outputView.printCarNameMessage();
            return new Cars(inputView.readCarNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return setUpCarName();
        }
    }

    private Integer setUpTryCount() {
        try {
            outputView.printTryCountMessage();
            Integer tryCount = inputView.readMovingCount();
            System.out.println();
            return tryCount;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return setUpTryCount();
        }
    }
}
