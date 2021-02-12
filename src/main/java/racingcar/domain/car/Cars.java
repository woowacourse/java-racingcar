package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void goForwardAllCarsRandomly() {
        for (Car car : cars) {
            car.goForwardRandomly();
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<String> getWinnerNames() {
        return getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        final Position maxPosition = new Position(getMaxPosition());

        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(RuntimeException::new);
    }
}
