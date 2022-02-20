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

    private final Cars cars;
    private final Round round;

    public RacingCarService(String[] carNames, int roundNumber) {
        this.cars = Cars.create(carNames);
        this.round = new Round(roundNumber);
    }

    public boolean isEnd() {
        return round.isEnd();
    }

    public RacingRecord run() {
        cars.move(new RandomMovementStrategy());
        round.decrease();
        CarsResponse result = new CarsResponse(cars);
        return new RacingRecord(result);
    }

    public List<CarResponse> getWinners() {
        return cars.findWinners().stream()
            .map(CarResponse::new)
            .collect(Collectors.toList());
    }
}
