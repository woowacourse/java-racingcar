package model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Vehicle> cars;

    public Cars(List<Vehicle> cars) {
        this.cars = cars;
    }

    public void moveAll() {
        cars.stream()
                .filter(MovableStrategy::isMove)
                .forEach(Vehicle::updateDistance);
    }

    public List<Vehicle> getWinner() {
        int winnerDistance = cars.stream()
                .mapToInt(Vehicle::getDistance)
                .max()
                .orElseThrow();
        return cars.stream()
                .filter(car2 -> car2.getDistance() == winnerDistance)
                .collect(Collectors.toList());
    }

    public List<Vehicle> getCars() {
        return cars;
    }
}
