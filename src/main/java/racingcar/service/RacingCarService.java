package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Cars;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.domain.round.Round;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class RacingCarService {

    private final Cars cars;
    private final Round round;

    public RacingCarService(String[] carNames, String roundNumber) {
        this.cars = Cars.create(carNames);
        this.round = new Round(roundNumber);
    }

    public boolean isEnd() {
        return round.isEnd();
    }

    public CarsDto run() {
        cars.move(new RandomMovementStrategy());
        round.decrease();
        return new CarsDto(cars);
    }

    public List<CarDto> getWinners() {
        return cars.findWinners().stream()
            .map(CarDto::new)
            .collect(Collectors.toList());
    }
}
