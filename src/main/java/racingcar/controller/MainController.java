package racingcar.controller;

import racingcar.domain.Car;
import java.util.List;

public class MainController {
    private List<Car> cars;
    private int tryNum;

    public MainController() {
    }

    public void play() {
        cars = InputController.inputcars();
        tryNum = InputController.inputTryNum();

        CarController.startRace(cars, tryNum);
        CarController.finalWinner(cars);
    }
}