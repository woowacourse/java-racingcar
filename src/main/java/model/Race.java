package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import utils.RandomNumberGenerator;

public class Race {

    private final List<Car> cars;

    public Race(List<String> carNames) {
        cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(new Name(name)));
        }
    }


    public void oneGame() {
        for (Car car : cars) {
            executeRandomMove(car, RandomNumberGenerator.generateRandomNumber());
        }
    }

    private void executeRandomMove(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.move();
        }
    }

    public List<String> selectWinners() {
        Collections.sort(cars);
        Car winner = cars.get(0);

        return cars.stream()
                .filter(car -> winner.showDistance().length() == car.showDistance().length())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getCarsName() {
        List<String> carNames = new ArrayList<>();

        for (Car car : cars) {
            carNames.add(car.getName());
        }

        return carNames;
    }

    public List<String> getDistances() {
        List<String> carDistances = new ArrayList<>();

        for (Car car : cars) {
            carDistances.add(car.showDistance());
        }

        return carDistances;
    }
}
