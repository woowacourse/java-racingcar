package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Cars;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.domain.round.Round;
import racingcar.dto.CarResponse;
import racingcar.dto.CarsResponse;
import racingcar.dto.RacingRecord;

public class RacingCarService {

    public boolean isEnd(Round round) {
        return round.isEnd();
    }

    public RacingRecord run(Cars cars, Round round) {
        cars.move(new RandomMovementStrategy());
        round.decrease();
        CarsResponse result = new CarsResponse(cars);
        return new RacingRecord(result);
    }

    public List<CarResponse> getWinners(Cars cars) {
        return cars.findWinners().stream()
            .map(CarResponse::new)
            .collect(Collectors.toList());
    }
}
