package racingcar.domain.racingcargame;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.NumberGenerator;
import racingcar.domain.trynumber.TryNumber;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private Cars cars;
    private final TryNumber tryNumber;

    public RacingCarGame(Cars cars, TryNumber tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public List<Cars> execute(NumberGenerator numberGenerator) {
        List<Cars> runResult = new ArrayList<>();
        while (tryNumber.isMovable()) {
            cars = cars.play(numberGenerator);
            runResult.add(cars);
        }

        return runResult;
    }

    public List<Car> findWinners() {
        int maxPosition = cars.extractMaxPosition();
        return cars.extractSamePosition(maxPosition);
    }
}
