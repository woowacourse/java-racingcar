package controller;

import domain.CarsInfo;
import domain.RoundResult;
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
        CarsInfo carsInfo = setUpCarName();
        Integer tryCount = setUpTryCount();
        progressRacingGame(tryCount, carsInfo, new RandomNumberGenerator());
    }

    private void progressRacingGame(Integer tryCount, CarsInfo carsInfo, RandomNumberGenerator randomNumberGenerator) {
        RoundResult roundResult = new RoundResult();
        outputView.printResultGuideMessage();
        for (int round = 0; round < tryCount; round++) {
            carsInfo.progressRound(randomNumberGenerator, roundResult);
            outputView.printCurrentResult(carsInfo);
        }
        List<String> winners = carsInfo.findWinners();
        outputView.printFinalResult(carsInfo, winners);
    }

    private CarsInfo setUpCarName() {
        try {
            outputView.printCarNameMessage();
            return new CarsInfo(inputView.readCarNames());
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
