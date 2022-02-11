package racingcar.domain;

import java.util.List;

import racingcar.util.NumberGeneratePolicy;

public class RacingGame {
    private final Cars cars;
    private final Round round;
    private final NumberGeneratePolicy numberGeneratePolicy;

    public RacingGame(Cars cars, Round round, NumberGeneratePolicy numberGeneratePolicy) {
        this.cars = cars;
        this.round = round;
        this.numberGeneratePolicy = numberGeneratePolicy;
    }

    public RacingGame(List<String> carsName, int round, NumberGeneratePolicy numberGeneratePolicy) {
        this(Cars.from(carsName), Round.from(round), numberGeneratePolicy);
    }

    public static RacingGame createRacingGame(List<String> carsName, int round,
        NumberGeneratePolicy numberGeneratePolicy) {
        return new RacingGame(carsName, round, numberGeneratePolicy);
    }

    public void race() {
        cars.driveAll(numberGeneratePolicy);
    }

    public boolean isContinue() {
        return round.hasNext();
    }
}
