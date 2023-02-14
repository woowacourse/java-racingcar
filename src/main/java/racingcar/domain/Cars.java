package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<String> getWinner() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> isMaxPosition(car, maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        int maxPosition = -1;
        for (Car car : cars) {
            Position position = car.getPosition();
            maxPosition = Math.max(position.getPosition(), maxPosition);
        }
        return maxPosition;
    }

    private boolean isMaxPosition(Car car, int maxPosition) {
        Position position = car.getPosition();
        return maxPosition == position.getPosition();
    }
}
