package model;

import message.Constant;

import java.util.HashSet;
import java.util.List;
import static java.util.stream.Collectors.*;

public class Cars {

    private final int POWER_UPPER_BOUND_EXCLUSIVE = 10;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll(PowerGenerator powerGenerator) { // 모든 Car 들을 moveAll
        cars.forEach(
                car -> car.move(
                        powerGenerator.generate(POWER_UPPER_BOUND_EXCLUSIVE)
                ));
    }

    public List<Car> getWinners() {
        int maxDistanceOfCars = getMaxDistanceOfCars();

        return cars.stream()
                .filter(car -> car.isSameDistance(maxDistanceOfCars))
                .collect(toList());
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public int size() {
        return cars.size();
    }

    private int getMaxDistanceOfCars() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(Constant.START_POSITION);
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(joining());
    }
}
