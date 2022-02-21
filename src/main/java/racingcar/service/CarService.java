package racingcar.service;

import racingcar.model.car.Cars;
import racingcar.model.car.RandomNumber;

import java.util.List;

public class CarService {
    private final Cars cars;

    public CarService() {
        this.cars = new Cars();
    }

    public void createCars(List<String> names) {
        cars.create(names);
    }

    public void moveCars() {
        cars.move(RandomNumber.getNumbers(cars.getSize()));
    }

    public List<CarDto> findCarDtos() {
        return cars.getCarDtos();
    }
}
