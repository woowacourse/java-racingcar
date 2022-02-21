package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Cars;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.domain.round.Round;
import racingcar.dto.CarResponse;
import racingcar.dto.RacingRecord;

public class RacingCarService {

    public List<RacingRecord> getRacingRecords(Cars cars, Round round) {
        List<RacingRecord> racingRecords = new ArrayList<>();
        while (isEnd(round)) {
            racingRecords.add(run(cars, round));
        }
        return racingRecords;
    }

    private boolean isEnd(Round round) {
        return round.isEnd();
    }

    private RacingRecord run(Cars cars, Round round) {
        cars.move(new RandomMovementStrategy());
        round.decrease();
        return new RacingRecord(cars);
    }

    public List<CarResponse> getWinners(Cars cars) {
        return cars.findWinners().stream()
            .map(CarResponse::new)
            .collect(Collectors.toList());
    }
}
