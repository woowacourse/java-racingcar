package racingcar.domain.movingstrategy;

import racingcar.domain.Car;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final Random RANDOM = new Random();
    private static final int MAXIMUM_OPENED_VALUE = 9 + 1;
    private static final int MOVEMENT_CRITERION = 4;

    private RandomMovingStrategy() {
    }

    private static class SingletonHolder {
        private static final RandomMovingStrategy randomStrategy = new RandomMovingStrategy();
    }

    public static RandomMovingStrategy getInstance() {
        return SingletonHolder.randomStrategy;
    }

    @Override
    public Car move(final Car car) {
        if (RANDOM.nextInt(MAXIMUM_OPENED_VALUE) >= MOVEMENT_CRITERION) {
            return car.moveDefinitely();
        }
        return car;
    }
}
