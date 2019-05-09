package controller;

import domain.Car;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    public List<Car> makeCarList(List<String> carNameList) throws IllegalArgumentException {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        return carList;
    }
}
