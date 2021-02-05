package racingcar.domain;

import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(Names names) {
        this.cars = names.getNames().
                stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        for (Car car : cars) {
            car.movePosition(RandomUtils.generateRandomValue());
        }
    }

    public String getCurrentPosition() {
        StringBuilder currentPosition = new StringBuilder();
        for (Car car : cars) {
            currentPosition.append(car.getCurrentPosition());
            currentPosition.append("\n");
        }
        return currentPosition.toString();
    }

    public Car getMaxPositionCar() {
        return cars.stream().max(Car::compareTo).get();
    }

    public List<Car> getWinnerCars(Car maxPositionCar) {
        return cars.stream().filter(car -> car.hasSamePositionWith(maxPositionCar)).collect(Collectors.toList());
    }
}
