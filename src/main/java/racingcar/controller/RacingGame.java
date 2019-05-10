package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.GameResult;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final String RESULT_STR = "실행 결과";
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    private static final GameResult gameResult = new GameResult();

    public void run() {
        List<Car> cars = setCarName();
        int number = inputNumber();

        System.out.println("\n" + RESULT_STR);

        for (int i = 0; i < number; i++) {
            cars = getRacingPostion(cars);
        }

        System.out.println(resultView.printWinner(getWinner(cars)));
    }

    private List<Car> setCarName() {
        String[] name = inputView.inputName();
        List<Car> cars = new ArrayList<>();

        for (String carName : name) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private int inputNumber() {
        return inputView.inputNumber();
    }

    private List<Car> getRacingPostion(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move();
        }
        resultView.printResult(cars);

        return cars;
    }

    private List<String> getWinner(List<Car> cars) {
        return gameResult.racingResult(cars);
    }

}
