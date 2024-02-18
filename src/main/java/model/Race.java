package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public void startRound() {
        for (Car car : cars.getCars()) {
            executeRandomMove(car, Power.generatePower());
        }
    }

    private void executeRandomMove(Car car, int power) {
        if (power >= 4) {
            car.move();
        }
    }

    public List<String> selectWinners() {
        List<Car> cars = this.cars.getCars();
        Collections.sort(cars);
        Car winner = cars.get(0);

        return cars.stream()
                .filter(car -> winner.showDistance().length() == car.showDistance().length())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<String> getCarsName() {
        List<String> carNames = new ArrayList<>();

        for (Car car : cars.getCars()) {
            carNames.add(car.getName());
        }

        return carNames;
    }

    public List<String> getDistances() {
        List<String> carDistances = new ArrayList<>();

        for (Car car : cars.getCars()) {
            carDistances.add(car.showDistance());
        }

        return carDistances;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
