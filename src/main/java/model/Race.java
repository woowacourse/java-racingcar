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

        List<String> carNames = cars.stream()
                .filter(car -> winner.getDistance() == car.getDistance())
                .map(Car::getName)
                .collect(Collectors.toList());
        return carNames;
    }

    public List<String> getCarsName() {
        return cars.getCars().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
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
