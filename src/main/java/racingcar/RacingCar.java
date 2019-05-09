package racingcar;

import racingcar.domain.Car;
import racingcar.domain.MovableStrategy;
import racingcar.domain.RandomMovement;

public class RacingCar {
    static final MovableStrategy strategy = new RandomMovement();

    public static void main(String[] args) {
        Car c = new Car("ss");
        c.move(strategy);
    }

}
