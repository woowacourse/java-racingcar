package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> cars;

    public Winners(final List<Car> cars) {
        List<Car> copy = new ArrayList<>(cars);
        validateWinners(copy);
        this.cars = copy;
    }

    public List<String> getWinnersName() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validateWinners(final List<Car> copy) {
        if (copy.isEmpty()) {
            throw new IllegalStateException("우승자는 1명 이상이어야 합니다");
        }
    }
}
