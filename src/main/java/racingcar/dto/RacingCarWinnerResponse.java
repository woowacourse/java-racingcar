package racingcar.dto;

import static java.util.stream.Collectors.*;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Name;

public class RacingCarWinnerResponse {
    private final List<String> winners;

    public RacingCarWinnerResponse(List<String> winners) {
        this.winners = winners;
    }

    public static RacingCarWinnerResponse of(List<Car> winners) {
        List<String> names = winners.stream()
                .map(Car::getName)
                .map(Name::getName)
                .collect(toList());
        return new RacingCarWinnerResponse(names);
    }

    public List<String> getWinners() {
        return winners;
    }

    @Override
    public String toString() {
        return String.join(", ", winners);
    }
}
