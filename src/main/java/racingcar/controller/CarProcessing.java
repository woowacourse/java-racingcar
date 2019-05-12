package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarGenerator;

import java.util.List;
import java.util.Objects;

public class CarProcessing {
    private CarGenerator carGenerator;

    protected CarProcessing() {
        this.carGenerator = new CarGenerator();
    }

    protected List<Car> createCar(String[] carNames){
        return carGenerator.generateCars(carNames);
    }

    /* For Test */
    protected CarProcessing(CarGenerator carGenerator) {
        this.carGenerator = carGenerator;
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
