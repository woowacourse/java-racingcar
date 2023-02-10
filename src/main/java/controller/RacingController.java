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

    public void run() {
        Cars carsInfo = setUpCarName();
        Integer tryCount = setUpTryCount();
        progressRacingGame(tryCount, carsInfo, new RandomNumberGenerator());
    }

    public void progressRacingGame(Integer tryCount, Cars carsInfo, RandomNumberGenerator randomNumberGenerator) {
        RoundResult roundResult = new RoundResult();
        outputView.printResultGuideMessage();
        for (int round = 0; round < tryCount; round++) {
            progressRound(carsInfo, randomNumberGenerator, roundResult);
            outputView.printCurrentResult(carsInfo);
        }
        List<String> winners = carsInfo.findWinners();
        outputView.printFinalResult(carsInfo, winners);
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

    private void progressRound(Cars carsInfo, RandomNumberGenerator randomNumberGenerator, RoundResult roundResult) {
        carsInfo.progressRound(randomNumberGenerator, roundResult);
    }
}
