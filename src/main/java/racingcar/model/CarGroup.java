package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.RandomNumberGenerator;

public class CarGroup {
    private final List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(car);
    }

    public void race() {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.generate());
        }
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter((car -> car.getPosition() > 0 && car.getPosition() == maxPosition))
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
