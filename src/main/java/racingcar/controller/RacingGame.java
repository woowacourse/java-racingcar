package racingcar.controller;

import racingcar.constant.MessageConstants;
import racingcar.model.Car;
import racingcar.model.GameResult;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public void run() {
        List<Car> cars = makeCarCategory();
        int number = inputNumber();

        System.out.println("\n" + MessageConstants.RESULT);

        for (int i = 0; i < number; i++) {
            cars = oneRoundPosition(cars);
        }

        System.out.println(ResultView.printWinner(getWinner(cars)));
    }

    private List<Car> makeCarCategory() {
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

    private List<Car> oneRoundPosition(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).isMovePosiotion();
        }
        ResultView.printResult(cars);

        return cars;
    }

    private List<String> getWinner(List<Car> cars) {
        return GameResult.racingResult(cars);
    }

}
