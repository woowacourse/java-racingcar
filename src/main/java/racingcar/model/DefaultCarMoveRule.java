package racingcar.model;

import racingcar.utils.Random;

public class DefaultCarMoveRule implements CarMoveRule {

    private static final int RANGE_START = 0;
    private static final int RANGE_END = 9;
    private static final int THRESHOLD = 4;

    @Override
    public boolean isGo() {
        return Random.pickNumberInRange(RANGE_START, RANGE_END) >= THRESHOLD;
    }
}
