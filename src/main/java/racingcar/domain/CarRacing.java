package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {
    private final List<Car> cars;
    private int moveNumber;

    public CarRacing(List<String> names, int moveNumber) {
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        this.moveNumber = moveNumber;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();
        return cars.stream()
                .filter((car) -> car.isWinner(maxDistance))
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMoveNumber() {
        return this.moveNumber;
    }
}
