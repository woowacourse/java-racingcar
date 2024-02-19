package racingcar.dto.response;

import racingcar.domain.car.Car;

import java.util.List;

public record RaceWinnersResponse(List<String> raceWinners) {
    public static RaceWinnersResponse from(final List<Car> raceWinners) {
        List<String> raceWinnersResponse = raceWinners.stream()
                .map(Car::getName)
                .toList();

        return new RaceWinnersResponse(raceWinnersResponse);
    }
}
