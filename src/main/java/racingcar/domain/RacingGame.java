package racingcar.domain;

import java.util.List;
import racingcar.controller.CarDto;

public class RacingGame {
    private final Cars cars;
    private final NumberGeneratePolicy numberGeneratePolicy;
    private Round round;

    private RacingGame(Cars cars, Round round, NumberGeneratePolicy numberGeneratePolicy) {
        this.cars = cars;
        this.round = round;
        this.numberGeneratePolicy = numberGeneratePolicy;
    }

    public static RacingGame createRacingGame(Cars cars, Round round,
                                              NumberGeneratePolicy numberGeneratePolicy) {
        return new RacingGame(cars, round, numberGeneratePolicy);
    }

    public List<CarDto> race() {
        cars.driveAll(numberGeneratePolicy);
        return getCurrentCars();
    }

    public boolean hasNextGame() {
        if (this.round.isValidRound()) {
            this.round = round.toNextRound();
            return true;
        }
        return false;
    }

    public List<CarDto> getCurrentCars() {
        return this.cars.getCurrentCars();
    }

    public List<CarDto> findCarsOfWinner() {
        return cars.getWinners();
    }
}
