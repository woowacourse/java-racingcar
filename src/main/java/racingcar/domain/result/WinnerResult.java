package racingcar.domain.result;

import static java.util.stream.Collectors.toUnmodifiableSet;

import java.util.List;
import java.util.Set;
import racingcar.domain.Car;

public class WinnerResult {

    private final Set<String> winners;

    public WinnerResult(List<Car> winners) {
        this.winners = winners.stream()
            .map(Car::getName)
            .collect(toUnmodifiableSet());
    }

    public Set<String> getWinnerNames() {
        return winners;
    }
}
