package racingcar.domain;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private final Cars cars;
    private final Round round;

    public CarRacingGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public List<CarsDto> race() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        List<CarsDto> carStatusesPerRound = new ArrayList<>();

        while (!isGameEnd()) {
            CarsDto currentCarStatuses = playRound(numberGenerator);
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

    public CarsDto playRound(NumberGenerator numberGenerator) {
        cars.moveCars(numberGenerator);
        round.decrease();
        return new CarsDto(cars.getCars());
    }

    public List<Car> getCurrentCarStatuses() {
        return cars.getCars();
    }
}
