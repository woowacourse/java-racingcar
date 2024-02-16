package racingcar.domain;

import java.util.List;

public class Winner {
    private final List<String> winners;

    public static Winner from(final List<Car> cars) {
        return new Winner(cars.stream().map(Car::getName).toList());
    }

    private Winner(final List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }
}
