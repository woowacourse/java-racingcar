package controller;

import domain.Car;
import domain.Winner;
import java.util.ArrayList;
import java.util.List;
import utils.CarGenerator;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingGame {
    private final CarGenerator carGenerator;
    private final InputView inputView;
    private final Winner winner;
    private List<Car> cars;
    private int tryCount;

    public RacingGame() {
        carGenerator = new CarGenerator();
        inputView = new InputView();
        winner = new Winner();
        cars = new ArrayList<>();
    }

    public void initGame() {
        OutputView.printMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = inputView.getCarNames(inputView.getInput());
        cars = carGenerator.generateCars(carNames);
        OutputView.printMessage("시도할 회수는 몇회인가요?");
        this.tryCount = inputView.getTryCount(inputView.getInput());
    }

    public void start() {
        OutputView.printMessage("실행 결과");
        while (this.tryCount-- > 0) {
            int power = RandomNumberGenerator.generateRandomPower();
            cars.forEach(car -> car.move(power));
            OutputView.printEachCarDistance(cars);
        }
    }

    public void printResult() {
        winner.findWinnerNames(cars);
        OutputView.printWinner(winner);
    }
}
