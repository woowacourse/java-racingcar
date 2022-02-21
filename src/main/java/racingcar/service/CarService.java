package racingcar.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class CarService {

    public String[] splitCarNames(final String names) {
        return names.split(",");
    }

    public List<Car> race(final List<Car> cars) {
        Random random = new Random();
        return cars.stream()
                .map(c -> c.race(random.nextInt(10)))
                .collect(Collectors.toList());
    }

    public List<String> getWinners(final List<Car> cars) {
        final int max = getMaxPosition(cars);
        return cars.stream()
                .filter(c -> c.getPosition() == max)
                .map(c -> c.getName())
                .collect(Collectors.toList());
    }

    private int getMaxPosition(final List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(car.getPosition(), max);
        }
        return max;
    }
}
