package racingcar.controller;

import racingcar.domain.Car;
import java.util.List;

public class MainController {
    private List<Car> carList;
    private int tryNum;

    public MainController() {
    }

    public void play() {
        carList = InputController.inputCarList();
        tryNum = InputController.inputTryNum();

        CarController.raceStart(carList, tryNum);
        CarController.finalWinner(carList);
    }
}
