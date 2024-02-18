package racingcar.domain;

import java.util.List;

public class Winners {
    private final List<String> winners;

    private Winners(final List<String> winners) {
        this.winners = winners;
    }

    public static Winners from(final List<Car> cars) {
        return new Winners(cars.stream().map(Car::getName).toList());
    }
    
    public List<String> getWinners() {
        return winners;
    }
}
