package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final Cars cars;

    public Winners(Cars cars) {
        this.cars = cars;
    }

    public List<String> getWinnerCarNames() {
        return cars.getCars().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
