package controller;

import domain.Car;
import domain.FinalResult;
import domain.MovingCount;
import domain.RoundResult;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private List<Car> carInfo = new ArrayList<>();
    private MovingCount movingCount;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final RoundResult roundResult = new RoundResult();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void setUp() {
        outputView.printCarNameMessage();
        for (String carName : inputView.readCarNames()) {
            carInfo.add(new Car(carName));
        }
        outputView.printTryCountMessage();
        movingCount = new MovingCount(inputView.readMovingCount());
        System.out.println();
    }

    public void run() {
        System.out.println("실행 결과");
        for (int round = 0; round < movingCount.getCount(); round++) {
            for (Car car : carInfo) {
                Integer randomNumber = randomNumberGenerator.generateRandomNumber();
                boolean movingResult = roundResult.isGo(randomNumber);
                car.move(movingResult);
            }
            outputView.printCurrentResult(carInfo);
        }
        FinalResult finalResult = new FinalResult();
        List<String> winners = finalResult.findWinners(carInfo);
        outputView.printWinners(winners);
    }
}
