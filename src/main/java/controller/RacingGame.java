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
    private final Winner winner;
    private List<Car> cars;
    private int tryCount;

    public RacingGame() {
        carGenerator = new CarGenerator();
        winner = new Winner();
        cars = new ArrayList<>();
    }

    public void initGame() {
        String[] carNames = InputView.getCarNames();
        cars = carGenerator.generateCars(carNames);
        this.tryCount = InputView.getTryCount();
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
