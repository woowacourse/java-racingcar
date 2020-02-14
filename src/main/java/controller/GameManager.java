package controller;

import model.Car;
import model.Dice;
import model.Winner;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Car> cars = new ArrayList<>();
    private Winner winner = new Winner();
    private int round;
    private static final int MIN_MOVE_NUMBER = 4;
    static final int ZERO = 0;

    private static String[] inputCarName() {
        return InputView.inputCarName();
    }

    public void startGame() {
        init();
        run();
        award();
    }

    public static void moveOrStay(Car car, int RandomNumber) {
        if (RandomNumber >= MIN_MOVE_NUMBER) {
            car.move();
        }
    }

    private void init() {
        setCarList(inputCarName());
        setRound();
    }

    private void race(List<Car> cars) {
        for (Car car : cars) {
            moveOrStay(car, Dice.makeRandomNumber());
        }
    }

    private void run() {
        OutputView.printBeginResult();
        for (int i = ZERO; i < round; i++) {
            race(cars);
            OutputView.printScore(cars);
        }
    }

    private void award() {
        winner.setWinner(cars);
        OutputView.printWinners(winner.getWinners());
    }

    public List<Car> getCarList() {
        return this.cars;
    }

    private void setRound() {
        this.round = InputView.inputRound();
    }

    void setCarList(String[] carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }
}
