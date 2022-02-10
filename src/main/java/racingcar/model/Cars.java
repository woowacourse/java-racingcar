package racingcar.model;

import racingcar.util.RandomNumberGenerator;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void race() {
        this.cars.forEach(car -> {
                    car.move(RandomNumberGenerator.generate());
                });
    }
    
}
