package racingcar.domain;

import racingcar.utils.RandomValueGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(Names names) {
        this.cars = names.getNames().
                stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public HashMap<String, Integer> getCurrentCarsInfo() {
        HashMap<String, Integer> info = new HashMap<>();
        for (Car car: cars) {
            info.put(car.getName(), car.getPosition());
        }
        return info;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(RandomValueGenerator.generateRandomNumber());
        }
    }

    public Car getMaxPositionCar() {
        return cars.stream().max(Car::compareTo).get();
    }

    public List<Car> getWinners() {
        Car maxPositionCar = getMaxPositionCar();
        return cars.stream()
                .filter(car -> car.hasSamePositionWith(maxPositionCar))
                .collect(Collectors.toList());
    }
}
