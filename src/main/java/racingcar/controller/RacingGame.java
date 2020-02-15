package racingcar.controller;

import racingcar.domain.Round;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.result.RacingResult;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final Round round;

    public RacingGame(String carsName, String roundNumber) {
        List<Car> cars = Cars.generateCarsByInput(carsName);
        Round round = new Round(roundNumber);

        this.cars = cars;
        this.round = round;
    }

    public RacingResult play() {
        while (round.isGoing()) {
            Cars.play(cars);
        }

        return new RacingResult(cars);
    }
}