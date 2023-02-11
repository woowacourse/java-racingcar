package model;

import util.NumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final String COMMA = ",";
    private final String BLANK = " ";

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carsName) {
        List<String> carNames = splitCarName(carsName);

        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private List<String> splitCarName(String carsName) {
        return Arrays.asList(carsName.split(COMMA));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveResult(NumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            car.moveByNumber(randomNumberGenerator.generateNumber());
        }
    }

    public String getWinners() {
        int maxLocation = cars.stream()
                              .max(Comparator.comparingInt(Car::getLocation))
                              .get()
                              .getLocation();

        return cars.stream()
                   .filter(car -> car.isLocationEqual(maxLocation))
                   .map(Car::getName)
                   .collect(Collectors.joining(COMMA + BLANK));
    }
}
