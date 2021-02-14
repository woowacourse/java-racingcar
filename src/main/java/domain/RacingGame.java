package domain;

import car.Car;
import java.util.List;

public class RacingGame {

    private final List<Car> carNames;
    private final int round;

    public RacingGame(List<Car> carNames, int round) {
        this.carNames = carNames;
        this.round = round;
    }


}
