package model;

import util.NumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(String carsName) {
        List<String> carNames = splitCarName(carsName);

        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private List<String> splitCarName(String carsName) {
        return Arrays.asList(carsName.split(","));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveResult(NumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            car.moveByRandom(randomNumberGenerator.generateNumber());
        }
    }

    public String getWinners() {
        int maxLocation = cars.stream()
                .max(Comparator.comparingInt(Car::getCarLocation))
                .get().getCarLocation();

        return cars.stream().filter(car -> car.checkLocationEqual(maxLocation))
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }
}
