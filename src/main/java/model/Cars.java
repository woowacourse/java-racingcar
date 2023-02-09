package model;

import util.RandomNumberGenerator;

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

    public void moveResult() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (Car car : cars) {
            car.moveByRandom(createRandom(randomNumberGenerator));
        }
    }

    private int createRandom(RandomNumberGenerator randomNumberGenerator) {
        return randomNumberGenerator.generateNumber();
    }


    public List<String> getWinners() {
        int maxLocation = cars.stream()
                .max(Comparator.comparingInt(Car::getCarLocation))
                .get().getCarLocation();

        return cars.stream().filter(car -> car.getCarLocation() == maxLocation)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
