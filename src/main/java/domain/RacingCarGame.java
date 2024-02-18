package domain;

import dto.RacingResult;
import dto.RacingStatus;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final Cars cars;
    private final Count count;

    public RacingCarGame(Cars cars, Count count) {
        this.cars = cars;
        this.count = count;
    }

    public RacingResult start() {
        List<RacingStatus> racingStatuses = new ArrayList<>();
        for (int i = 0; i < count.getValue(); i++) {
            RacingStatus racingStatus = cars.race();
            racingStatuses.add(racingStatus);
        }
        return new RacingResult(racingStatuses, cars.getWinners());
    }
}
