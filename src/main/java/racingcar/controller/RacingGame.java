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
    private final InputView INPUTVIEW = new InputView();
    private final ResultView RESULTVIEW = new ResultView();
    private final GameResult GAMERESULT = new GameResult();

    public void run() {
        List<Car> cars = setCarName();
        int number = inputNumber();

        System.out.println("\n" + MessageConstants.RESULT);

        for (int i = 0; i < number; i++) {
            getRacingPosition(cars);
        }

        RESULTVIEW.printWinner(getWinner(cars));
    }

    private List<Car> setCarName() {
        String[] name = INPUTVIEW.inputName();
        List<Car> cars = new ArrayList<>();

        for (String carName : name) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private int inputNumber() {
        return INPUTVIEW.inputNumber();
    }

    private void getRacingPosition(List<Car> cars) {
        for (Car car : cars) {
            car.move(getRandomNumber());
        }
        RESULTVIEW.printResult(cars);
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }


    private List<String> getWinner(List<Car> cars) {
        return GAMERESULT.racingResult(cars);
    }

}
