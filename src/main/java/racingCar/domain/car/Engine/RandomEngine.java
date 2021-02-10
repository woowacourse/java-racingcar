package racingCar.domain.car.Engine;

import racingCar.utils.RandomUtils;


public class RandomEngine implements Engine {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;


    @Override
    public boolean isMove() {
        final int move_criteria = 3;
        return RandomUtils.nextInt(MIN_VALUE, MAX_VALUE) > move_criteria;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
