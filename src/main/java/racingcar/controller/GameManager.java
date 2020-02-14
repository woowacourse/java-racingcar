package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Dice;
import racingcar.model.Winner;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    public static final int ZERO = 0;
    private static final int MIN_MOVE_NUMBER = 4;
    private static List<Car> cars = new ArrayList<>();
    private int round;

    public GameManager(String[] carNames, int round) {
        this.cars = setCars(carNames);
        this.round = round;
    }

    public static List<Car> setCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void startGame() {
        run();
        award();
    }

    private void run() {
        OutputView.printBeginResult();
        for (int i = ZERO; i < round; i++) {
            race(cars);
            OutputView.printScore(cars);
        }
    }

    private void award() {
        Winner.setWinner(cars);
        OutputView.printWinners(Winner.getWinners());
    }

    public static void moveOrStay(Car car, int inputNumber) {
        if (inputNumber >= MIN_MOVE_NUMBER) {
            car.move();
        }
    }

    public static void race(List<Car> cars) {
        for (Car car : cars) {
            moveOrStay(car, Dice.makeRandomNumber());
        }
    }
}
