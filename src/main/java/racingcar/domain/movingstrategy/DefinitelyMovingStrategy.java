package racingcar.domain.movingstrategy;

import racingcar.domain.Car;

public class DefinitelyMovingStrategy implements MovingStrategy {
    private DefinitelyMovingStrategy() {
    }

    private static class SingletonHolder {
        private static final DefinitelyMovingStrategy definitelyMovingStrategy = new DefinitelyMovingStrategy();
    }

    public static DefinitelyMovingStrategy getInstance() {
        return DefinitelyMovingStrategy.SingletonHolder.definitelyMovingStrategy;
    }

    @Override
    public Car move(Car car) {
        return car.moveDefinitely();
    }
}
