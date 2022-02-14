package racingcar.domain.result;

import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.domain.Car;

public class WinnersResult {

    private final List<Car> winners;

    public WinnersResult(List<Car> winners) {
        this.winners = winners;
    }

    public List<String> getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(toList());
    }
}
