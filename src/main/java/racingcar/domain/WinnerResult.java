package racingcar.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class WinnerResult {

    List<Car> winners;

    public WinnerResult(List<Car> winners) {
        this.winners = winners;
    }

    public List<String> getWinnerNames() {
        return winners.stream().map(Car::getName).collect(toList());
    }
}
