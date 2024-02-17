package racingcar.domain.rules;

import racingcar.domain.rules.CarMoveRule;
import racingcar.utils.Random;

public class DefaultCarMoveRule implements CarMoveRule {

    private static final int THRESHOLD = 4;

    @Override
    public boolean isGo() {
        return Random.pickNumber() >= THRESHOLD;
    }
}
