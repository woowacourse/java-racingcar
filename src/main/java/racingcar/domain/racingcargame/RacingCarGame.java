package racingcar.domain.racingcargame;

import racingcar.domain.car.Cars;
import racingcar.domain.car.util.RandomNumberGenerator;
import racingcar.domain.trynumber.TryNumber;

public class RacingCarGame {

    private final Cars cars;
    private final TryNumber tryNumber;

    public RacingCarGame(Cars cars, TryNumber tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public void execute(RandomNumberGenerator randomNumberGenerator) {
        while (tryNumber.isMovable()) {
            cars.play(randomNumberGenerator);
        }
    }

    public Cars getCars() {
        return cars;
    }
}
