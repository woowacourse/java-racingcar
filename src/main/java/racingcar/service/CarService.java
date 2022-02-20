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
}
