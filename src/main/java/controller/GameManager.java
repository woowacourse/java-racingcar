package controller;

import model.Car;
import model.Dice;
import model.Winner;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    public static final int ZERO = 0;
    private static final int MIN_MOVE_NUMBER = 4;
    private static List<Car> cars = new ArrayList<>();
    private int round;

    private static String[] inputCarName() {
        return InputView.inputCarName();
    }

    public void startGame() {
        init();
        run();
        award();
    }

    private void award() {
        Winner.setWinner(cars);
        OutputView.printWinners(Winner.getWinners());
    }

    private void init() {
        setCarList(inputCarName());
        setRound();
    }

    public static void moveOrStay(Car car, int inputNumber) {
        if (inputNumber >= MIN_MOVE_NUMBER) {
            car.move();
        }
    }

    private void run() {
        OutputView.printBeginResult();
        for (int i = ZERO; i < round; i++) {
            race(cars);
            OutputView.printScore(cars);
        }
    }

    public static List<Car> getCarList() {
        return cars;
    }

    public static void setCarList(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void setRound() {
        this.round = InputView.inputRound();
    }

    public static void race(List<Car> cars) {
        for (Car car : cars) {
            moveOrStay(car, Dice.makeRandomNumber());
        }
    }
}
