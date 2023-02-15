package racingcar.model;

import racingcar.CarNumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void tryOneTime(CarNumberGenerator carNumberGenerator) {
        for (Car car : cars) {
            int randomValue = carNumberGenerator.generate();
            car.move(car.canMoving(randomValue));
        }
    }

    public List<Car> getWinners() {
        Car maxPositionCar = getMaxPositionCar();
        return getMaxPositionCars(maxPositionCar);
    }

    private Car getMaxPositionCar() {
        Car maxPositionCar = cars.get(0);
        for (Car car : cars) {
            maxPositionCar = car.getLargerCar(maxPositionCar);
        }
        return maxPositionCar;
    }

    private List<Car> getMaxPositionCars(Car maxPositionCar) {
        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePositionCar(maxPositionCar))
                .collect(Collectors.toList());
        return winners;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
