package domain;

import dto.RacingResult;
import dto.RacingStatus;

import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGame {
    private final Cars cars;
    private final Count count;

    public RacingCarGame(Cars cars, Count count) {
        this.cars = cars;
        this.count = count;
    }

    public RacingResult start() {
        List<RacingStatus> racingStatuses = IntStream.range(0, count.getValue())
                .mapToObj(i -> cars.race())
                .toList();
        return new RacingResult(racingStatuses, cars.getWinners());
    }
}
