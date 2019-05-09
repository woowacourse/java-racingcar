package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Random;
import racingcar.view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Car> carList = new ArrayList<>();

    public void run() {
        String[] carNames = View.inputNameOfCar();
        this.carListInit(carNames);
        int numberOfTry = View.inputNumberOfTry();
        this.moveCarsByNumberOfTry(numberOfTry);

    }

    private void moveCarsByNumberOfTry(int numberOfTry) {
        for (int i = 0; i < numberOfTry; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : carList) {
            car.move(Random.isEnableGo());
        }
    }

    void carListInit(String[] carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

}
