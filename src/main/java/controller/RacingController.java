package controller;

import domain.Car;
import domain.FinalResult;
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
        List<Car> carsInfo = setUpCarName();
        Integer movingCount = setUpTryCount();
        progressRacingGame(movingCount, carsInfo, new RandomNumberGenerator());
    }

    public void progressRacingGame(Integer movingCount, List<Car> carsInfo, RandomNumberGenerator randomNumberGenerator) {
        RoundResult roundResult = new RoundResult();
        System.out.println("실행 결과");
        for (int round = 0; round < movingCount; round++) {
            for (Car car : carsInfo) {
                Integer randomNumber = randomNumberGenerator.generateRandomNumber();
                boolean movingResult = roundResult.isGo(randomNumber);
                car.move(movingResult);
            }
            outputView.printCurrentResult(carsInfo);
        }
        FinalResult finalResult = new FinalResult();
        List<String> winners = finalResult.findWinners(carsInfo);
        outputView.printFinalResult(carsInfo, winners);
    }

    private List<Car> setUpCarName() {
        List<Car> carsInfo = new ArrayList<>();
        initCarsInfo(carsInfo);
        return carsInfo;
    }

    private Integer setUpTryCount() {
        try {
            outputView.printTryCountMessage();
            Integer tryCount = inputView.readMovingCount();
            System.out.println();
            return tryCount;
        } catch (IllegalArgumentException e) {
            return setUpTryCount();
        }
    }

    private void initCarsInfo(List<Car> carsInfo) {
        try {
            outputView.printCarNameMessage();
            carsInfo.clear();
            checkCarNameValidation(carsInfo);
        } catch (IllegalArgumentException e) {
            initCarsInfo(carsInfo);
        }
    }

    private void checkCarNameValidation(List<Car> carsInfo) {
        for (String carName : inputView.readCarNames()) {
            carsInfo.add(new Car(carName));
        }
    }
}
