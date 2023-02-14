package racinggame.controller;

import racinggame.domain.Car;
import racinggame.domain.CarGenerator;
import racinggame.domain.RacingGame;
import racinggame.utils.NumberGenerator;
import racinggame.utils.RandomNumberGenerator;
import racinggame.view.Input;
import racinggame.view.Output;

import java.util.List;

public class RacingGameController {
    private static final NumberGenerator numberGenerator = new RandomNumberGenerator();
    private static final CarGenerator carGenerator = new CarGenerator();

    private String[] carNames;
    private int tryCount;
    private RacingGame racingGame;
    private List<Car> cars;

    public void run() {
        init();
        racingGame = new RacingGame(cars, tryCount, this.numberGenerator);
        racingGame.run();
        printResult(cars, tryCount);
    }

    private void init() {
        Output.printMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        this.carNames = Input.getCarNames(Input.getInput());
        Output.printMessage("시도할 회수는 몇회인가요?");
        this.tryCount = Input.getTryCount(Input.getInput());
        this.cars = carGenerator.generateCars(carNames);
    }

    private void printResult(List<Car> cars, int tryCount) {
        Output.printEachCarResult(cars, tryCount);
        Output.printWinner(racingGame.getWinner());
    }
}
