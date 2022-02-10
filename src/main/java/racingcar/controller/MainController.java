package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.Input;

import java.util.Arrays;
import java.util.List;

public class MainController {
    private List<Car> carList;
    private int tryNum;
    public MainController() {
    }

    public void play(){
        carList = InputController.inputCarList();
        tryNum = InputController.inputTryNum();

        CarController.raceStart(carList, tryNum);
        CarController.finalWinner(carList);
    }
}
