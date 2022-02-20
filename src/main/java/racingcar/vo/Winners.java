package racingcar.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private static final String WINNERS_DELIMITER = ", ";

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = new ArrayList<>(winners);
    }

    @Override
    public String toString() {
        return winners.stream()
                .map(Car::getName)
                .map(CarName::getName)
                .collect(Collectors.joining(WINNERS_DELIMITER));
    }
}
