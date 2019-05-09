package racingcar.controller;

import racingcar.model.CarList;
import racingcar.model.WinningCars;


public class Controller {

    public CarList makeCarList(String[] carNames) {
        CarList carList = new CarList(carNames);
        return carList;
    }

    public CarList moveCar(CarList carList) {
        carList.moveCars();
        return carList;
    }

    public WinningCars getWinningCars(CarList carList) {
        return carList.getWinnerCars();
    }
}
