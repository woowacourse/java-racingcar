package racingcar.dto.response;

import java.util.List;
import racingcar.domain.car.Car;

public record RaceWinnersResponse(List<String> raceWinners) {
    public static RaceWinnersResponse from(final List<Car> raceWinners) {
        final List<String> raceWinnersResponse = raceWinners.stream()
                .map(Car::getName)
                .toList();

        return new RaceWinnersResponse(raceWinnersResponse);
    }
}
