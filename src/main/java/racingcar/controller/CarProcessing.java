package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarGenerator;

import java.util.List;
import java.util.Objects;

public class CarProcessing {

    protected CarProcessing() {
    }

    protected List<Car> createCar(String[] carNames){
        return CarGenerator.generateCars(carNames);
    }

    protected void race(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    /* For Test */
    protected List<Car> race(List<Car> cars, int num) {
        for (Car car : cars) {
            car.move(num);
        }

        return cars;
    }
}
