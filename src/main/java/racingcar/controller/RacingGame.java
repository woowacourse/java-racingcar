package racingcar.controller;

import racingcar.constant.MessageConstants;
import racingcar.model.Car;
import racingcar.model.GameResult;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final int MAX_BOUND = 10;

    public void run() {
        List<Car> cars = setCarName();
        int number = inputNumber();

        System.out.println("\n" + MessageConstants.RESULT);

        for (int i = 0; i < number; i++) {
            printOneRoundResult(cars);
        }

        ResultView.printWinner(getWinner(cars));
    }

    private List<Car> setCarName() {
        String[] name = InputView.inputName();
        List<Car> cars = new ArrayList<>();

        for (String carName : name) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private int inputNumber() {
        return InputView.inputNumber();
    }

    private void printOneRoundResult(List<Car> cars) {
        for (Car car : cars) {
            car.makeNewCar(getRandomNumber());
        }
        ResultView.printResult(cars);
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    private List<String> getWinner(List<Car> cars) {
        return GameResult.racingResult(cars);
    }

}
