package controller;

import model.Car;
import model.Dice;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static List<Car> cars = new ArrayList<>();
    private int round;

    private static String[] inputCarName() {
        return InputView.inputCarName();
    }

    public void startGame() {
        init();
        run();
    }

    private void init() {
        setCarList(inputCarName());
        setRound();
    }

    private void run() {
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            race(cars);
            OutputView.printScore(cars);
        }
    }

    private void setRound() {
        this.round = InputView.inputCount();
    }

    public static List<Car> getCarList() {
        return cars;
    }

    public static void setCarList(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public static void moveOrStay(Car car, int inputNumber) {
        if (inputNumber >= 4) {
            car.move();
        }
    }

    public static void race(List<Car> cars) {
        for (Car car : cars) {
            moveOrStay(car, Dice.makeRandomNumber());
        }
    }
}
