package racingCar.domain.car.Engine;

import racingCar.utils.RandomUtils;


public class RandomEngine implements Engine {

    public static final int CRITERIA = 3;
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    @Override
    public boolean movable() {
        return RandomUtils.nextInt(MIN_VALUE, MAX_VALUE) > CRITERIA;
    }
}
