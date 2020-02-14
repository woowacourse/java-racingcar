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
    private static int currentRound = 0;

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

    public static void race() {
        for (Car car : cars) {
            moveOrStay(car, Dice.makeRandomNumber());
        }
        OutputView.printScore(cars);
        currentRound += 1;
    }

    public static void moveOrStay(Car car, int inputNumber) {
        if (inputNumber >= MIN_MOVE_NUMBER) {
            car.move();
        }
    }

    public static List<String> getWinners() {
        return Winner.getWinners(cars);
    }

    public boolean isNotEnd() {
        return this.round > this.currentRound;
    }
}
