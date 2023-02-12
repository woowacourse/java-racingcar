package racingcar.controller.response;

import racingcar.domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerResponse {

    private final List<String> winnerNames;

    public WinnerResponse(final List<Car> winners) {
        this.winnerNames = winners.stream()
                .map(it -> it.name().value())
                .collect(Collectors.toList());
    }

    public List<String> winnerNames() {
        return winnerNames;
    }
}
