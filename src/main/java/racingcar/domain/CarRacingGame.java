package racingcar.domain;

import racingcar.dto.CarsDto;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private final Cars cars;
    private final Round round;

    public CarRacingGame(final Cars cars, final Round round) {
        this.cars = cars;
        this.round = round;
    }

    public List<CarsDto> race() {
        final NumberGenerator numberGenerator = new RandomNumberGenerator();
        final List<CarsDto> carStatusesPerRound = new ArrayList<>();

        while (!isGameEnd()) {
            final CarsDto currentCarStatuses = playRound(numberGenerator);
            carStatusesPerRound.add(currentCarStatuses);
        }

        return carStatusesPerRound;
    }

    public boolean isGameEnd() {
        return round.isLast();
    }

    public List<Car> findWinners() {
        return cars.findCarsAtMaxPosition();
    }

    public CarsDto playRound(final NumberGenerator numberGenerator) {
        cars.moveCars(numberGenerator);
        round.decrease();
        return new CarsDto(cars.getCars());
    }

    public List<Car> getCurrentCarStatuses() {
        return cars.getCars();
    }
}
