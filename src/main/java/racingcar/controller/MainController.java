package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.Input;

import java.util.Arrays;
import java.util.List;

public class MainController {
    private List<Car> carList;

    public MainController() {
    }

    public void play(){
        InputController.inputData(carList);
        
    }
}
