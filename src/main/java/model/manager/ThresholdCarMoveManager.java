package model.manager;

import util.RandomNumberValidator;

public class ThresholdCarMoveManager implements CarMoveManager {
    private static final int BOUNDARY_VALUE = 4;

    @Override
    public boolean isMove(int number) {
        RandomNumberValidator.validate(number);
        return number >= BOUNDARY_VALUE;
    }

}
