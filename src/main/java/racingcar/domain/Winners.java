package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<String> winners;

    public Winners(final Cars cars) {
        int maxPosition = getMaxPosition(cars);
        this.winners = createWinners(cars, maxPosition);
    }

    private int getMaxPosition(final Cars cars) {
        int maxPosition = 0;
        for (Car car : cars.getCars()) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    private List<String> createWinners(final Cars cars, final int maxPosition) {
        return cars.getCars().stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<String> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
