package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> winners = new ArrayList<>();

    public Winners(final Cars cars) {
        Car maxPositionCar = cars.getMaxPositionCar();
        for (Car car : cars.cars()) {
            allocateWinner(car, maxPositionCar);
        }
    }

    private void allocateWinner(final Car car, final Car maxPositionCar) {
        if (car.isMaxPosition(maxPositionCar)) {
            winners.add(car);
        }
    }

    public List<String> getWinnersNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}

