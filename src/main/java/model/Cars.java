package model;

import util.NumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<String> carsName) {
        for (String name : carsName) {
            cars.add(new Car(new Name(name)));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveResult(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.moveByRandom(numberGenerator.generateNumber());
        }
    }

    public String getWinners() {
        return cars.stream().filter(car -> car.checkLocationEqual(getMaxLocation()))
                .map(Car::getCarName)
                .map(Name::getName)
                .collect(Collectors.joining(", "));
    }

    private int getMaxLocation(){
        return cars.stream()
                .max(Comparator.comparingInt(Car::getCarLocation))
                .get().getCarLocation();
    }
}
