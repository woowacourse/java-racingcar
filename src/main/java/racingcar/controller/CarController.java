package racingcar.controller;

import racingcar.domain.Cars;

public class CarController {
    private Cars cars;

    void createCars(String[] names) {
        this.cars = new Cars(names);
    }

    public void race(int time) {
        for (int i = 0; i < time; i++) {
            cars.startRace();
        }
    }
}
