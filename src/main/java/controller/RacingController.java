package controller;

import domain.Car;
import domain.CarsInfo;
import domain.RoundResult;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        CarsInfo carsInfo = setUpCarName();
        Integer tryCount = setUpTryCount();
        progressRacingGame(tryCount, carsInfo, new RandomNumberGenerator());
    }

    public void progressRacingGame(Integer tryCount, CarsInfo carsInfo, RandomNumberGenerator randomNumberGenerator) {
        RoundResult roundResult = new RoundResult();
        outputView.printResultGuideMessage();
        for (int round = 0; round < tryCount; round++) {
            progressRound(carsInfo, randomNumberGenerator, roundResult);
            outputView.printCurrentResult(carsInfo);
        }
        List<String> winners = carsInfo.findWinners();
        outputView.printFinalResult(carsInfo, winners);
    }

    private CarsInfo setUpCarName() {
        List<Car> carsInfo = new ArrayList<>();
        initCarsInfo(carsInfo);
        return new CarsInfo(carsInfo);
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

    private void initCarsInfo(List<Car> carsInfo) {
        try {
            outputView.printCarNameMessage();
            carsInfo.clear();
            checkCarNameValidation(carsInfo);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            initCarsInfo(carsInfo);
        }
    }

    private void checkCarNameValidation(List<Car> carsInfo) {
        for (String carName : inputView.readCarNames()) {
            carsInfo.add(new Car(carName));
        }
    }

    private void progressRound(CarsInfo carsInfo, RandomNumberGenerator randomNumberGenerator, RoundResult roundResult) {
        carsInfo.progressRound(randomNumberGenerator, roundResult);
    }
}
