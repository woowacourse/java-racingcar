package controller;

import domain.Cars;
import domain.RoundResult;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;
import java.util.List;

public class RacingController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void run() {
        Cars cars = setUpCarName();
        int tryCount = setUpTryCount();
        progressRacingGame(tryCount, cars);
    }

    public void progressRacingGame(int tryCount, Cars cars) {
        RoundResult roundResult = new RoundResult();
        outputView.printResultGuideMessage();
        for (int round = 0; round < tryCount; round++) {
            progressRound(cars, roundResult);
            outputView.printCurrentResult(cars.getCarsDto());
        }
        List<String> winners = cars.findWinners();
        outputView.printFinalResult(cars.getCarsDto(), winners);
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

    private int setUpTryCount() {
        try {
            outputView.printTryCountMessage();
            int tryCount = inputView.readTryCount();
            System.out.println();
            return tryCount;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return setUpTryCount();
        }
    }

    private void progressRound(Cars cars, RoundResult roundResult) {
        cars.progressRound(
                randomNumberGenerator.generateBoundaryNumbers(cars.getCount()),
                roundResult
        );
    }
}
