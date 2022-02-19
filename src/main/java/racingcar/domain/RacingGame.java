package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final NumberGeneratePolicy numberGeneratePolicy;
    private Round round;

    public RacingGame(final Cars cars, final Round round, final NumberGeneratePolicy numberGeneratePolicy) {
        this.cars = cars;
        this.round = round;
        this.numberGeneratePolicy = numberGeneratePolicy;
    }

    public List<Car> race() {
        cars.driveAll(numberGeneratePolicy);
        return Collections.unmodifiableList(cars.getDriveRecord());
    }

    public boolean isFinished() {
        if (this.round.isPositiveNumber()) {
            this.round = round.reduce();
            return true;
        }
        return false;
    }

    public List<Car> getRacingResult() {
        return Collections.unmodifiableList(cars.getWinners());
    }
}
