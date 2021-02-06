package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        validateWinners();
    }

    public List<String> getWinnersName() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validateWinners() {
        if (this.cars.isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
